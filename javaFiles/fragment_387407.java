public static void main(String[] args) throws ParseException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
    String s = "abc";
    Field stringValue = String.class.getDeclaredField("value");
    stringValue.setAccessible(true);
    char[] chars = (char[]) stringValue.get(s);

    //now reverse
}