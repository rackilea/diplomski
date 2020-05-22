Map<String, List<Object>> values = new HashMap<>();


public Map<String, List<Object>> getPublicMethods(String api) throws ClassNotFoundException {

    Map<String, List<Object>> values = new HashMap<>();

    Class clazz = Class.forName("android.hardware.Camera");
    Method[] publicMethods= clazz.getDeclaredMethods();

    List<Object> listArgument = //Get Arguments Here

    for (Method met : publicMethods) 
        values.put(met.getName(), listArgument); 
    return values;
}