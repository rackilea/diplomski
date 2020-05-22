public class BrushFactory {
    public native JavaScriptObject newJavaBrush() /*-{
        return new $wnd.SyntaxHighlighter.brushes.Java();
    }-*/;

    public native JavaScriptObject newXmlBrush() /*-{
        return new $wnd.SyntaxHighlighter.brushes.Xml();
    }-*/;
}