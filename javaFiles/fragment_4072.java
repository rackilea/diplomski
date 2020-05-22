@Test
public void exampleTest() {
    Map<Integer, String> myMap = new HashMap<>();
    ParameterizedType type = (ParameterizedType) myMap.getClass().getGenericSuperclass();
    System.out.println("Array of actual types : " + Arrays.toString(type.getActualTypeArguments()));
}