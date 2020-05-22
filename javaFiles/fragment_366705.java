obj.doStuff(new MyFunction() {
    @Override
    public void apply(Object session, MyClass self) throws Exception {
        String s = session.toString();
        System.out.println(s);
        self.setRowCount(5);
    }
});