@JsonAnySetter
public void setAnyValues(String propertyName, Object value) {
    if (propertyName.startsWith("tag_")) {
        if (value instanceof String) {
            tags.add(new Tag(propertyName, value.toString()));
        } else if (value instanceof List) {
            List<?> values = (List<?>) value;
            for (Object v : values) {
                tags.add(new Tag(propertyName, v.toString()));
            }
        }
        // throw exception?
    } else {
        // handle another unknown properties
    }
}