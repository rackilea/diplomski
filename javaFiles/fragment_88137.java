class Test {
    static class TestObject {
        private int a = 1;
        protected int b = 2;
        public int c = 3;
        int d = 4;
        String s = "s";
    }

    static main(args) {
        def o = ['a':1,b:'2',c:'3','d':5,s:'s'] as TestObject
        println o.d
    }
}