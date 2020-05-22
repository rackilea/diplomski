public static void main(String[] args) throws Exception {
    Derived derived = (Derived) getObject();
}

public static Base getObject() {
    if (Math.random() > 0.5) {
        return new Base();
    } else {
        return new Derived();
    }
}