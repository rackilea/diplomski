public static void main(String args[]) {
    Object1Type a = new Object3Type();

    if (a instanceof Object3Type) {
        Object3Type b = (Object3Type) a;
        byte[] bytes = b.value;
    }
}