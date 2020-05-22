public class MyClass {
    private final Object1 obj1;
    private final Object2 obj2;
    private final Object3 obj3;

    private MyClass(MyClassBuilder builder) {
        this.obj1 = builder.obj1;
        this.obj2 = builder.obj2;
        this.obj3 = builder.obj3;
    }

    public getObj1() { return obj1; }
    public getObj2() { return obj2; }
    public getObj3() { return obj3; }

    public static class Builder {
        private final Object1 obj1;
        private final Object2 obj2;
        private final Object3 obj3;

        public Builder() {}

        public Builder setObj1(Object1 obj1) {this.obj1 = obj1; return this; }
        public Builder setObj2(Object2 obj2) {this.obj2 = obj2; return this; }
        public Builder setObj3(Object3 obj3) {this.obj3 = obj3; return this; }

        public MyClass build() {
            return new MyClass(this);
        }
    }

}

public class MyClassJSonExtractor {
    // make the as singleton, either by the old-fashioned way or by Spring
    public MyClass createMyClass(String jsonString) {
         return new MyClass.Builder().
             setObj1(...).
             setObj2(...).
             setObj3(...).
             build();
    }
}