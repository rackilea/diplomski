Map<String, String> transactionBatchHashMap = new HashMap<>();
for (int i = 0; i < nodeList.getLength(); i++) {
            transactionBatchHashMap.put(getNodeValue(nodeList, i, "transactionBatch"),
                                        getNodeValue(nodeList, i, "transactionBatchDate"));
        }

        transactionBatchHashMap = sortMapByValues(transactionBatchHashMap);