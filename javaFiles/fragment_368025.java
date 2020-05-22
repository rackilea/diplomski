void setProperty(String aPropertyName, String aPropertyValue) {
        try {
            if (aPropertyName.equals(AField.FieldName.getName())) {
                fieldName = aPropertyValue;
            }
            else if (aPropertyName.equals(AField.DetailFieldName.getName())) {
                detailFieldName = aPropertyValue;
            }
            else if (aPropertyName.equals(AField.ExternalFieldName.getName())) {
                externalFieldName = aPropertyValue;
            }
            else if (aPropertyName.equals(AField.FormatLength.getName())) {
                formatLength = Integer.parseInt(aPropertyValue);
            }
            /* more if's */
        } catch (Exception e) {
            /* logging exceptions */
        }
    }