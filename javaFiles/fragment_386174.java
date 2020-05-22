class Object3Type implements Object2Type {
    byte[] value;
}

class Object4Type implements Object2Type {
    byte[] value;
}

class DemoApplication {

    public static void main(String args[]) {
        Object1Type a = new Object3Type();

        Object3Type b = (Object3Type) a; // Compiles and works without exceptions
        Object4Type c = (Object4Type) a; // java.lang.ClassCastException: Object3Type cannot be cast to Object4Type
    }
}