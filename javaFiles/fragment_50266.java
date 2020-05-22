static void printCaptures(Function<Integer, String> f) throws Exception {
    System.out.println(f.getClass());
    for (Field field : f.getClass().getDeclaredFields()) {
        field.setAccessible(true);
        System.out.println(field.getName() + ": " + field.get(f));
    }
}