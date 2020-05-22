package stackoverflow;

import stackoverflow.OtherClass.OtherClassInner;

public class Main {
    public static void main(String[] args) throws Exception {
        OtherClassInner inner = new OtherClassInner();
    }
}

class OtherClass {
    static class OtherClassInner {

    }
}