class A extends B {
    @Override
    public void don() { // <-- will not compile if don is private in B.
        System.out.println("hoho public");
    }
}