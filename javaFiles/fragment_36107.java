for (Map.Entry<String, String> entry : myMap.entrySet()){

    Class<?> clazz = Class.forName(entry.getValue());
    ADBBean bean = (ADBBean)clazz.newInstance();
    Method method = clazz.getMethod("methodName", String.class, Integer.class, etc);
    method.invoke(bean, "blah", 145);
}