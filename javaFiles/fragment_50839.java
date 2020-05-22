class ScribbleInput {
    private static ScribbleInput INSTANCE = new ScribbleInput();
    private ScribbleInput() {}

    public static String getString(String foo, String bar) {
        return INSTANCE.getString(foo, bar);
    }
}