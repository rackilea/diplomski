/**
 * De-serializes JSON to a Java Object.
 * <p>
 * Also provides handling of simple data type validation.  If a {@link JsonMappingException} is thrown then it
 * is wrapped as a {@link ValidationException} and handled by the MVC/validation framework.
 *
 * @author John Strickler
 * @since 2012-08-28
 */
public class EntityArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private SessionFactory sessionFactory;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger log = Logger.getLogger(EntityArgumentResolver.class);

    //whether to log the incoming JSON
    private boolean doLog = false;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().getAnnotation(Entity.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        String requestBody = IOUtils.toString(request.getReader());
        Class<?> targetClass = parameter.getParameterType();
        Object entity = this.parse(requestBody, targetClass);
        Object entityId = getId(entity);

        if(doLog) {
            log.info(requestBody);
        }

        if(entityId != null) {
            return copyObjectToPersistedEntity(entity, getKeyValueMap(requestBody), entityId);
        } else {
            return entity;
        }
    }


    /**
     * @param rawJson a json-encoded string
     * @return a {@link Map} consisting of the key/value pairs of the JSON-encoded string
     */
    @SuppressWarnings("unchecked")
    private Map<String, Object> getKeyValueMap(String rawJson) throws JsonParseException, JsonMappingException, IOException {
        return objectMapper.readValue(rawJson, HashMap.class);
    }


    /**
     * Retrieve an existing entity and copy the new changes onto the entity.
     *
     * @param changes a recently deserialized entity object that contains the new changes
     * @param rawJson the raw json string, used to determine which keys were passed to prevent
     *                copying unset/null values over to the persisted entity
     * @return the persisted entity with the new changes copied onto it
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    private Object copyObjectToPersistedEntity(Object changesObject, Map<String, Object> changesMap, Object id) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {

        Session session = sessionFactory.openSession();

        Object persistedObject =
                session.get(changesObject.getClass(), (Serializable) id);

        session.close();

        if(persistedObject == null) {
            throw new ValidationException(changesObject.getClass().getSimpleName() + " #" + id + " not found.");
        }

        Class<?> clazz = persistedObject.getClass();

        for(Method getterMethod : ReflectionUtils.getAllDeclaredMethods(clazz)) {

            Column column = getterMethod.getAnnotation(Column.class);

            //Column annotation is required
            if(column == null) {
                continue;
            }

            //Is the field allowed to be updated?
            if(!column.updatable()) {
                continue;
            }

            //Was this change a part of JSON request body?
            //(prevent fields false positive copies when certain fields weren't included in the JSON body)
            if(!changesMap.containsKey(BeanUtils.toFieldName(getterMethod))) {
                continue;
            }

            //Is the new field value different from the existing/persisted field value?
            if(ObjectUtils.equals(getterMethod.invoke(persistedObject), getterMethod.invoke(changesObject))) {
                continue;
            }

            //Copy the new field value to the persisted object
            log.info("Update " + clazz.getSimpleName() + "(" + id + ") [" + column.name() + "]");

            Object obj = getterMethod.invoke(changesObject);

            Method setter = BeanUtils.toSetter(getterMethod);

            setter.invoke(persistedObject, obj);

        }

        return persistedObject;
    }


    /**
     * Check if the recently deserialized entity object was populated with its ID field
     *
     * @param entity the object
     * @return an object value if the id exists, null if no id has been set
     */
    private Object getId(Object entity) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {

        for(Method method : ReflectionUtils.getAllDeclaredMethods(entity.getClass())) {
            if(method.getAnnotation(Id.class) != null) {
                method.setAccessible(true);
                return method.invoke(entity);
            }
        }

        return null;
    }


    private <T> T parse(String json, Class<T> clazz) throws JsonParseException, IOException {
        try {
            return objectMapper.readValue(json, clazz);
        } catch(JsonMappingException e) {
            throw new ValidationException(e);
        }
    }

    public void setDoLog(boolean doLog) {
        this.doLog = doLog;
    }

}