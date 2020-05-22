public final native JsArray<Columns> getColumns() /*-{ return this.columns; }-*/;
public final native JsArray<Data> getData() /*-{ return this.data; }-*/;

public static class Data extends JavaScriptObject {
    protected Data() {}

    public final native String getValue(String key) /*-{ return this[key]; }-*/;
}
public static class Columns extends JavaScriptObject {
    protected Columns() {}
    public final native String getValue() /*-{ return this; }-*/;
}