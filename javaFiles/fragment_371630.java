package org.stackoverflow.helizone.test;

import java.lang.reflect.Field;

public class ConfigurationProcessor {
    public String toJson(Configuration configuration) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Field[] fields = configuration.getClass().getDeclaredFields();
        for (Field fld : fields) {
            String fieldName = fld.getName();

            JsonArrayMember fieldAnnotation = fld.getAnnotation(JsonArrayMember.class);
            if (fieldAnnotation == null) {
                // field not annotated with @JsonArrayMember, skip
                System.out.println("Skipping property " + fieldName + " -- no @JsonArrayMember annotation");
                continue;
            }

            if (!fld.getType().equals(Boolean.class)) {
                // field is not of boolean type -- skip??
                System.out.println("Skipping property " + fieldName + " -- not Boolean");
                continue;
            }

            Boolean value = null;

            try {
                value = (Boolean) fld.get(configuration);
            } catch (IllegalArgumentException | IllegalAccessException exception) {
                // TODO Auto-generated catch block
                exception.printStackTrace();
            }

            if (value == null) {
                // the field value is null -- skip??
                System.out.println("Skipping property " + fieldName + " -- value is null");
                continue;
            }

            if (value.booleanValue()) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }

                sb.append(fieldAnnotation.value());
            } else {
                System.out.println("Skipping property " + fieldName + " -- value is FALSE");
            }
        }

        return sb.toString();
    }
}