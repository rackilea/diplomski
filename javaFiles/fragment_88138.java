class Test {
    static class TestObject {
        TestObject() {
        }

        TestObject(a,b,c,d,s) {
            this.a = a
            this.b = b
            this.c = c
            this.d = d
            this.s = s
        }


        private int a = 1;
        protected int b = 2;
        public int c = 3;
        int d = 4;
        String s = "s";
    }

    static main(args) {
        def obj = ['a':1,b:'2',c:'3','d':5,s:'s'] as TestObject
        assert obj.d == 5
        obj = [1, 2, 3, 6, 's'] as TestObject
        assert obj.d == 6
    }
}