public static void main(String[] args) {
    TypeReference<List<String>> ref = new TypeReference<List<String>>() {};

    List<String> list = new ArrayList<String>();

    Type rawType = ((ParameterizedType)ref.getType()).getRawType();
    boolean listIsInstanceOfRawType = ((Class<?>)(rawType)).isInstance(list));

    System.out.println(listIsInstanceOfRawType); // true
}