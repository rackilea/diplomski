public class CustomProperties {
    private String value;
    private String type;

    private void setValue(Object value, String type) {
        if (value != null) {
            this.value = value.toString();
            this.type = type;
        }
    }

    private Object getValue() {
        if (value != null) {
            if ("int".equals(type)) return Integer.valueOf(value);
            elseif ("date".equals(type)) return // Parse date from value here
            elseif ("string".equals(type)) return (String) value;
            // other cases
        }
        return value;
    }