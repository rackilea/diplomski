ConcurrentHashMap<String, Object> newMap = new ConcurrentHashMap<>();
ConcurrentHashMap<String, Object> beanMapForInstance = instanceSpecificBeanMap.putIfAbsent(currentInstanceId, newMap);
if (beanMapForInstance == null) {
    beanMapForInstance = newMap;
}
(... work with beanMapForInstance ...)