Resource getResource = resourceResolver.getResource("/content/AboutPage/jcr:content/list");
ValueMap property = getResource.adaptTo(ValueMap.class);
for(Entry<String, Object> e : property.entrySet()) {
    String key = e.getKey();
    Object value = e.getValue();
    //use the key and value here
}