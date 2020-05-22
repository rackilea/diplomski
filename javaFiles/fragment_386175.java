interface Object1Type extends Base {
    byte[] getValue();
}

interface Object2Type extends Object1Type {}

class Object3Type implements Object2Type {
    byte[] value;

    public byte[] getValue() {
        return value;
    }
}

class DemoApplication {

    public static void main(String args[]) {
        Object1Type a = new Object3Type();
        byte[] bytes = a.getValue();
    }
}