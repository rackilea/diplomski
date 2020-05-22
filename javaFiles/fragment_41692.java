for (Map.Entry<String, String> entry : transactionBatchHashMap.entrySet()) {

            HSSFRow batchRow = spreadSheet.createRow(rowNumber);
            ...

            for (int i = 0; i < nodeList.getLength(); i++) {
                String transactionBatchValue = getNodeValue(nodeList, i, "transactionBatch");
                String hashMapBatchKeyValue = entry.getKey();

                if (transactionBatchValue.equals(hashMapBatchKeyValue)) {   
                ...