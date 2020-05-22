interface CommonInterface {
    void setBar(String str);
    void setFoo(String str);
}

class Object1Adapter implements CommonInterface {
    private final Object1 obj;

    public Object1Adapter(Object1 obj) {
        this.obj = obj;
    }

    @Override
    public void setBar(String str) {
        obj.setBar(str);
    }
    ...
}

class Object2Adapter implements CommonInterface {...}
class Object3Adapter implements CommonInterface {...}