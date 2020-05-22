for (Map.Entry<String, Object> entry : data.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();
        String staticMappingValue = (String) STATIC_MAPPING.get(key);

        if (staticMappingValue != null) {
            newMap.put(staticMappingValue, value);
        } else {
            newMap.put(key, value);
        }
    }