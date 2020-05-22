public static class MyFoo extends MyBar {

    @Override
    public Number getFoo() { // compile error: The return type is incompatible with MyBar.getFoo()
        return super.getFoo();
    }

}