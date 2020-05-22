//loop through custom fields for custom field data.
        for(SearchColumnCustomField field: fieldArray){
            //_console.writeLn(field.getInternalId() + " " + field.getScriptId());

            //Then we are at the [Custom Field internalId: 1855].
            if (field.getInternalId().equals("1855")){
                SearchColumnStringCustomField searchBodyField = (SearchColumnStringCustomField)field;
                couponCode = searchBodyField.getSearchValue();
            }
            //Then we are at the [Custom Field internalId: 681]
            if (field.getInternalId().equals("681")){
                SearchColumnStringCustomField searchBodyField = (SearchColumnStringCustomField)field;
                orderId = searchBodyField.getSearchValue();
            }
        }