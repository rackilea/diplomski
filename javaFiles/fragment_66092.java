public static void main(String... none) throws Exception {
    Field[] fields1 = Point.class.getFields();
    Field[] fields2 = Point.class.getFields();
    for (int i = 0; i < fields1.length; ++i) {
        compare(fields1[i], fields2[i]);
    }
}

static void compare(Field field1, Field field2) {
    System.out.format("Field  %s\n", field1.getName());
    System.out.format("field1 == field2 -> %s\n", field1 == field2);
    System.out.format("field1.equals(field2) -> %s\n", field1.equals(field2));
    System.out.format("field1.hashCode() == field2.hashCode() -> %s\n", field1.hashCode() == field2.hashCode());
    System.out.println();
}