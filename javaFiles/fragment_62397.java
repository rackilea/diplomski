public class Tour extends JavaScriptObject {

    protected Tour() {
    }

    public static Tour getInstance() {
        return getInstance(null, null);
    }

    public static Tour getInstance(String name) {
        return getInstance(name, null);
    }

    public static native Tour getInstance(String name, JsArray<JavaScriptObject> array) /*-{
        return {
            name : name,
            array : array || []
        };
    }-*/;

    // the rest of your class stays untouched...

    public final native void setTourName(String name)/*-{
        this.name = name;
    }-*/;

    public final native String getTourName()/*-{
        return this.name;
    }-*/;

    public final native JsArray<JavaScriptObject> getArray() /*-{
        return this.array;
    }-*/;

    public final native void setJsArray(JsArray<JavaScriptObject> array)/*-{
        this.array = array;
    }-*/;

    public final native void push(JavaScriptObject obj)/*-{
        this.array.push(obj);
    }-*/;

    public final native int getLength()/*-{
        this.array.length;
    }-*/;
}