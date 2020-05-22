new JSONDeserializer().use("some.path.to.bar", new EnhancedStringObjectFactory() ).deserialize( json, new SomeObject() );



public class EnhancedStringObjectFactory implements ObjectFactory {
    public Object instantiate(ObjectBinder context, Object value, Type targetType, Class targetClass) {
        if( value instanceof String ) {
            return value;
        } else if( value instanceof Number ) {
            return ((Number)value).toString();
        } else {
           throw context.cannotConvertValueToTargetType(value, String.class);
        }
   }
}