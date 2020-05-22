<!-- language: lang-java -->
/**
 * Implements a create-object-set-property Digester rule.
 */
public class SetPropertyRule
    extends Rule
{
    private String _classAttributeName;
    private String _nameAttributeName;
    private String _valueAttributeName;
    private HashSet<String> _acceptableClassNames;

    /**
     * Creates a new SetPreferenceRule with default attribute names and classes.
     *
     * Default class attribute name = "type".
     * Default name attribute name = "name".
     * Default value attribute name = "value".
     * Default allowed classes = String, Integer, Double, and Boolean.
     */
    public SetPropertiesRule()
    {
        this("type", "name", "value",
             new Class<?>[] { String.class, Integer.class, Double.class, Boolean.class });
    }

    /**
     * Creates a new SetPropertyRule to construct a name/value pair and
     * set it on a Properties object.
     *
     * The Properties object should be at the top of the current
     * Digester stack.
     *
     * @param classAttributeName The name of the attribute that holds the property's value type.
     * @param nameAttributeName The name of the attribute that holds the property's name.
     * @param valueAttributeName The name of the attribute that holds the property's value.
     * @param acceptableClasses The list of acceptable property value types.
     */
    public SetPreferenceRule(String classAttributeName, String nameAttributeName, String valueAttributeName, Class<?>[] acceptableClasses)
    {
        super();

        _classAttributeName = classAttributeName;
        _nameAttributeName = nameAttributeName;
        _valueAttributeName = valueAttributeName;
        _acceptableClassNames = new HashSet<String>(acceptableClasses.length);
        for(Class<?> clazz : acceptableClasses)
            _acceptableClassNames.add(clazz.getName());
    }

    @Override
    public void begin(String namespace,
                      String name,
                      Attributes attributes)
        throws Exception
    {
        // Store the values of these attributes on the digester param stack
        getDigester().pushParams(
                attributes.getValue(_classAttributeName),
                attributes.getValue(_nameAttributeName),
                attributes.getValue(_valueAttributeName)
        );
    }

    @Override
    public void end(String namespace,
                    String name)
        throws Exception
    {
        Object[] attributeValues = getDigester().popParams();

        Object props = getDigester().peek();
        if(!(props instanceof java.util.Properties))
        {
            String typeName;
            if(null == props)
                typeName = "<null>";
            else
                typeName = props.getClass().getName();

            throw new IllegalStateException("Expected instance of " + Properties.class.getName() + ", got " + typeName + " instead");
        }

        String className = (String)attributeValues[0];
        checkClassName(className);

        // Create an instance of the preference value class
        Class<?> clazz = Class.forName(className);
        Constructor<?> cons = clazz.getConstructor(String.class);
        Object value = cons.newInstance((String)attributeValues[2]);

        ((Properties)props).put((String)attributeValues[1], value);
    }

    private void checkClassName(String className)
    {
        if(!_acceptableClassNames.contains(className))
            throw new IllegalArgumentException("Class " + className + " is not allowed");
    }
}