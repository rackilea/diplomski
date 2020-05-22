public String parseData(String Name) throws Exception {
    Class<?> cls = Class.forName(Name);
    Method[] methods = cls.getMethods();

    for (Method method : methods) {
        if(method.getName().equals("setData")) {
            method.invoke(cls.newInstance(), "Test");
        }
    }
    return null;
}