@FunctionalInterface
interface ISomeInterface
{
    void method();
}

void testMethod()
{
    x = new ISomeInterface(){
        @Override
        public void method() { foo(); }
        };
}