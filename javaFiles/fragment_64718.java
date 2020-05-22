public class Main {
    public static void main(String[] args) throws Exception {
        OtherClassInner inner = new OtherClassInner();
    }
}

class OtherClass {
    static class OtherClassInner {

    }
}

class YetAnotherClass {
    static class OtherClassInner {

    }
}