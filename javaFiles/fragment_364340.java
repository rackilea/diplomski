class Child extends Parent{
    @Override
    public void test(int a){
        a++;
        super.test(a);
    }
}