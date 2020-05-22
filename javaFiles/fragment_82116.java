public static void main(String[] args) throws Exception {
    Map<String, Object> props = getStuffForIdentifierAsMap("Zero's identifier");

    for (Map.Entry<String, Object> entry : props.entrySet()) {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}