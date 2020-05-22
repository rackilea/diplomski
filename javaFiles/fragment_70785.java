for (Map<String, Object> row : rows) {
    Object stock = row.get("stock");
    Object itemId = row.get("itemid");
    Object modelId = row.get("modelid");
    if (stock != null && itemId != null && modelId != null) {
        stockMap.put(Arrays.asList(modelId.toString(), itemId.toString()), 
                stock.toString());
    }
}