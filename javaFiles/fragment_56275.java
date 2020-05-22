public class EntityResultSetSecondPass implements QuerySecondPass
{
    private static final String ALIAS = EntityResultSetSecondPass.class.getName() + "_alias";
    private final InFlightMetadataCollector metadataCollector;

    private int entityAliasIndex;
    private final Map<Class<?>, String> aliasMap = new ConcurrentHashMap<>();

    public EntityResultSetSecondPass(final InFlightMetadataCollector metadataCollector)
    {
        this.metadataCollector = metadataCollector;
    }

    @Override
    public void doSecondPass(final Map persistentClasses) throws MappingException
    {
        for (final Object key : persistentClasses.keySet())
        {
            final String className = key.toString();
            try
            {
                final Class<?> clazz = Class.forName(className);
                final EntityResultSet entityResultSet = clazz.getDeclaredAnnotation(EntityResultSet.class);

                if (entityResultSet == null)
                {
                    continue;
                }
                else
                {
                    createEntityResultDefinition(entityResultSet, clazz);
                }
            }
            catch (final ClassNotFoundException e)
            {
                throw new HibernateException(e);
            }
        }
    }

    private void createEntityResultDefinition(final EntityResultSet entityResultSet, final Class<?> entityClass)
            throws ClassNotFoundException
    {
        final List<NativeSQLQueryReturn> mappedReturns = new ArrayList<>();
        final ResultSetMappingDefinition definition = new ResultSetMappingDefinition(entityResultSet.name());
        final Map<Class<?>, FieldResult[]> returnedEntities = new ConcurrentHashMap<>();

        returnedEntities.put(entityClass, entityResultSet.fields());

        for (final EntityResult entityResult : entityResultSet.relatedEntities())
        {
            returnedEntities.put(entityResult.entityClass(), entityResultSet.fields());
        }

        definition.addQueryReturn(new NativeSQLQueryRootReturn(getOrCreateAlias(entityClass), entityClass.getName(),
                getPropertyResults(entityClass, entityResultSet.fields(), returnedEntities, mappedReturns, ""),
                LockMode.READ));

        for (final EntityResult entityResult : entityResultSet.relatedEntities())
        {
            definition
                    .addQueryReturn(
                            new NativeSQLQueryRootReturn(getOrCreateAlias(entityResult.entityClass()),
                                    entityResult.entityClass().getName(), getPropertyResults(entityResult.entityClass(),
                                            entityResult.fields(), returnedEntities, mappedReturns, ""),
                                    LockMode.READ));
        }

        for (final NativeSQLQueryReturn mappedReturn : mappedReturns)
        {
            definition.addQueryReturn(mappedReturn);
        }

        metadataCollector.addResultSetMapping(definition);
    }

    private Map<String, String[]> getPropertyResults(final Class<?> entityClass, final FieldResult[] fields,
            final Map<Class<?>, FieldResult[]> returnedEntities, final List<NativeSQLQueryReturn> mappedReturns,
            final String prefix) throws ClassNotFoundException
    {
        final Map<String, String[]> properties = new ConcurrentHashMap<>();
        for (final Field field : entityClass.getDeclaredFields())
        {
            final Column column = field.getAnnotation(Column.class);
            if (column != null)
            {
                properties.put(prefix + field.getName(), new String[]
                { column.name() });
            }
            final JoinColumn joinColumn = field.getAnnotation(JoinColumn.class);
            if (joinColumn != null)
            {
                properties.putAll(handleJoinColumn(entityClass, field, joinColumn, returnedEntities, mappedReturns));
            }
        }

        if (entityClass.getSuperclass() != null)
        {
            properties.putAll(
                    getPropertyResults(entityClass.getSuperclass(), fields, returnedEntities, mappedReturns, prefix));
        }

        return properties;
    }

    private Map<String, String[]> handleJoinColumn(final Class<?> sourceEntity, final Field field,
            final JoinColumn joinColumn, final Map<Class<?>, FieldResult[]> returnedEntities,
            final List<NativeSQLQueryReturn> mappedReturns) throws ClassNotFoundException
    {
        final Map<String, String[]> properties = new ConcurrentHashMap<>();
        final OneToOne oneToOne = field.getAnnotation(OneToOne.class);
        if (oneToOne != null)
        {
            properties.put(field.getName(), new String[]
            { joinColumn.name() });
        }
        final OneToMany oneToMany = field.getAnnotation(OneToMany.class);

        if (oneToMany != null)
        {
            Class<?> fieldType;
            if (field.getType().isArray())
            {
                fieldType = field.getType();
            }
            else if (Collection.class.isAssignableFrom(field.getType()))
            {
                fieldType = Class.forName(
                        ParameterizedType.class.cast(field.getGenericType()).getActualTypeArguments()[0].getTypeName());
            }
            else
            {
                throw new UnsupportedOperationException("One to many only supports collection and array types");
            }

            if (returnedEntities.keySet().contains(fieldType))
            {
                properties.put(field.getName(), new String[]
                { joinColumn.name() });

                final Map<String, String[]> resolvedProperties = getPropertyResults(fieldType,
                        returnedEntities.get(fieldType), returnedEntities, mappedReturns, "element.");
                resolvedProperties.put("key", new String[]
                { joinColumn.referencedColumnName() });

                resolvedProperties.put("element", new String[]
                { joinColumn.name() });

                mappedReturns.add(new NativeSQLQueryCollectionReturn(getOrCreateAlias(fieldType),
                        sourceEntity.getName(), field.getName(), resolvedProperties, LockMode.READ));
                mappedReturns
                        .add(new NativeSQLQueryJoinReturn(getOrCreateAlias(fieldType),
                                getOrCreateAlias(sourceEntity), field.getName(), getPropertyResults(fieldType,
                                        returnedEntities.get(fieldType), returnedEntities, mappedReturns, ""),
                                LockMode.READ));
            }
        }

        return properties;
    }

    private String getOrCreateAlias(final Class<?> entityClass)
    {
        if (!aliasMap.containsKey(entityClass))
        {
            aliasMap.put(entityClass, ALIAS + entityAliasIndex++);
        }
        return aliasMap.get(entityClass);
    }
}