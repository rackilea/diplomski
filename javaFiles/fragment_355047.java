Map<String,T> tmpMap = new HashMap<String,T>();
JsonUnmarshallable ann;
for (T o : applicationContext.getBeansWithAnnotation(annotationType).values()) {
    ann = o.getClass().getAnnotation(JsonUnmarshallable.class);
    tmpMap.put(ann.value(),o);
}
return o;