public static void main(String[] args) {
    Map<String, String> values = new HashMap<>();
    values.put("876234876", "google");
    values.put("mike@hotmail", "hotmail");
    values.put("9879892", "google");
    System.out.println(createJson(values).toString(4));
}