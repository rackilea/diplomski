void testMethod()
{
    x = new ISomeInterface(){
        @Override
        public void method1() { foo(); }
        @Override
        public void method2() { bar(); }
        };
}