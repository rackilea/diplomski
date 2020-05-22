public final class MyConstants {
    public static final String MY_CONST_1 = "CONST_1";
    public static final String MY_CONST_2 = "CONST_2";
    public static final String MY_CONST_3 = "CONST_3";
    public static final String MY_CONST_4 = "CONST_4";
}

public static void main(String[] args) throws IllegalAccessException
{
    MyConstants constants = new MyConstants();
    java.util.Map<String, String> map = new java.util.LinkedHashMap<>();
    Field[] fields = constants.getClass().getDeclaredFields();

    for (Field field : fields) {
        map.put(field.getName(), (String) field.get(constants));
    }
    for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
        System.out.printf("Key: %s, Value: %s%n", entry.getKey(), entry.getValue());
    }
}