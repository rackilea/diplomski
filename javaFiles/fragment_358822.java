public static void main(String... args) throws IOException {
    Properties p = new Properties();
    p.load(Test.class.getResourceAsStream("/myfile.properties"));

    ObjectNode node = JsonNodeFactory.instance.objectNode();

    String prefix = "Category.";
    String delimiter = ",";

    p.forEach((k, v) -> {
        String propKey = k.toString();
        if (propKey.startsWith(prefix)) {
            String[] propVal = v.toString().split("=");
            ArrayNode array = JsonNodeFactory.instance.arrayNode();
            for (String arrVal : propVal[1].split(delimiter)) {
                array.add(arrVal);
            }
            node.set(propVal[0], array);
        }
    });

    System.out.println(node);
}