public class MyBy {
    /**
     * Returns a {@code By} which locates elements by the JavaScript expression passed to it.
     * 
     * @param script The JavaScript expression to run and whose result to return
     */
    public static By javascript(String script) {
        return new ByJavaScript(script);
    }
}