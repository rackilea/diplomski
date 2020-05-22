public class SyntaxHighlighter {
    public static native String highlight(String code, JavaScriptObject brush, boolean toolbar) /*-{
        var params = {};
        params['toolbar'] = toolbar;
        brush.init(params);
        return brush.getHtml(code);
    }-*/;
}