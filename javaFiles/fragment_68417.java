public static void main(String args[]) {
    String area[] = { "ABC", "XYZ", "PRQ" };
    ArrayTest at = new ArrayTest();
    at.setArea(area);
    XStream stream = new XStream();
    stream.alias("response",ArrayTest.class);
    stream.registerConverter(new NamedArrayConverter(at.getArea().getClass(), null, "code"));
    System.out.println(stream.toXML(at));
}