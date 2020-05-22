void setProperty(String aPropertyName, String aPropertyValue) {
        try {
            switch(AField.valueOf(aPropertyName)) {
                case FieldName:
                    fieldName = aPropertyValue;
                    break;
                case DetailFieldName:
                    detailFieldName = aPropertyValue;
                    break;
                case ExternalFieldName:
                    externalFieldName = aPropertyValue;
                    break;
                case FormatLength:
                    formatLength = Integer.parseInt(aPropertyValue);
                    break;
                // more cases
                default:
                    throw new AssertionError(AField.valueOf(aPropertyName).name());

            }
        } catch (Exception e) {
            /* logging exceptions */
        }
    }
}