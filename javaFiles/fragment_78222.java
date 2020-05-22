@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public class MarkerOptions {
    @JsProperty
    public double lat;

    @JsProperty
    public double lng;

    @JsProperty
    public boolean draggable;

    @JsProperty
    public Polygon[] fences;

    @JsFunction
    public interface FunctionOutsideParam {
        void outside(Marker m, Polygon[] f);
    }

    @JsProperty
    public FunctionOutsideParam outside;
}