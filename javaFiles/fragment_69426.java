class XML {
    void commonMethod() {}
}
class XML2 {
    void commonMethod() {}
}
// all code from here is under your control
interface XMLAdapter {
    void commonMethod();
}
class XMLWrapper implements XMLAdapter {
    private final XML impl;

    XMLWrapper(XML impl) {
        this.impl = impl;
    }

    @Override
    public void commonMethod() {
        impl.commonMethod();
    }
}
class XMLWrapper2 implements XMLAdapter {
    private final XML2 impl;

    XMLWrapper2(XML2 impl) {
        this.impl = impl;
    }

    @Override
    public void commonMethod() {
        impl.commonMethod();
    }
}