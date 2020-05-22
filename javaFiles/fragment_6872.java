/** Version compatibility adapter API */
interface Compat {
    void doY();
}

/** Adapter class for version 1 */
class CompatV1 {
    public void y(X x) {
       // do nothing
    }
}

/** Adapter class for version 2 */
class CompatV2 {
    public void y(X x) {
       x.y();
    }
}

// 
// Code to instantiate the relevant adapter for the current platform.
//
Class<?> compatClass;
// (Exception handling omitted)
if (BUILD.VERSION.RELEASE.compareTo("2.0") < 0) {
    compatClass = Class.forName("...CompatV1");
} else {
    compatClass = Class.forName("...CompatV2");
}
// (Exception handling omitted)
Compat compat = (Compat) compatClass.newInstance();

// The adapter object can be passed around as a parameter, wrapped
// as a singleton or injected using dependency injection.

// Invoke X.y() as follows:

X x = ...
compat.y(x);