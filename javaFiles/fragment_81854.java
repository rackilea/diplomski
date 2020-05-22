abstract class MyClass {
    private Map<String, String> textMap = new HashMap<>();

    public void addText(String key, String value) {
        textMap.put(key, value);
    }
}