public static void main(String[] args) throws InterruptedException {
        new TestClass<AnotherClass>().getK().get0();        
    }

class AnotherClass extends TestClass<AnotherClass>{
    int get0() {
        return 0;
    }   
}

class TestClass<K extends TestClass<K>> {
    K getK() {
        return (K)this;
    }
}