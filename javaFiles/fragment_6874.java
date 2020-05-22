for (FieldType fieldType : tableInfo.getFieldTypes()) {
            // if this is a foreign field and its foreign-id field is the same as the other's id
            FieldType foreignIdField = fieldType.getForeignIdField();
            if (fieldType.isForeign() && foreignIdField.equals(joinedQueryBuilder.tableInfo.getIdField())) {
                joinInfo.localField = fieldType;
                joinInfo.remoteField = foreignIdField;
                return;
            }
        }
        // if this other field is a foreign field and its foreign-id field is our id
        for (FieldType fieldType : joinedQueryBuilder.tableInfo.getFieldTypes()) {
            if (fieldType.isForeign() && fieldType.getForeignIdField().equals(idField)) {
                joinInfo.localField = idField;
                joinInfo.remoteField = fieldType;
                return;
            }
        }