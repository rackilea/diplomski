public class YourScriptlet extends JRDefaultScriptlet {
    private final YourInfoObject obj;
    public YourScriptlet(YourInfoObject obj) {
        this.obj = obj;
    }
    public void afterDetailEval() throws JRScriptletException {
        // your code here
        obj.set(count);
    }
}