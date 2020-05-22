public class FieldNamePayload 
{
    /**
     * Represents the field name "user_name"
     */
    public static class UserName implements ValuePayload
    {
        private static final String value = "user_name";

        @Override
        public String getValue() 
        {
            return value;
        }
    }
}