private static Map<String, Object> setNested(Map<String, Object> map, List<String> keys, Object value) {
      String key = keys.get(0);
      List<String> nextKeys = keys.subList(1, keys.size());
      Object newValue;
      if (nextKeys.size() == 0) {
        newValue = value;
      } else if (!map.containsKey(key)) {
        newValue = setNested(new LinkedHashMap<>(), nextKeys, value);
      } else {
        newValue = setNested((Map<String, Object>) map.get(key), nextKeys, value);
      }
      Map<String, Object> copyMap = new LinkedHashMap<>(map);
      copyMap.put(key, newValue);
      return copyMap;
    }