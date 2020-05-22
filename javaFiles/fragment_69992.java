public static <T> T getConfig(Class<T> type, String name) {
   if(type.equals(Integer.class)){
    return type.cast(xml.getInteger(name));
   } else if(type.equals(Float.class)){
    return type.cast(xml.getFloat(name));
   } else if(type.equals(Double.class)) {
    return type.cast(xml.getDouble(name));
   } else if(type.equals(String.class)) {
    return type.cast(xml.getString(name));
   } 
   throw new AssertionError("Invalid type");
}