public void updateItemFieldValues(int itemId, int fieldId,
            List<Map<String, Object>> values, boolean silent, boolean hook) {
        getResourceFactory()
                .getApiResource("/item/" + itemId + "/value/" + fieldId)
                .queryParam("silent", silent ? "1" : "0")
                .queryParam("hook", hook ? "1" : "0")
                .entity(values, MediaType.APPLICATION_JSON_TYPE).put();
    }
}