public static class MyElement {
    public static boolean getBoolean(Element e) {
        // Do your thing.
        return e.getValue() == "true" || e.getValue() == "1";
    }
}