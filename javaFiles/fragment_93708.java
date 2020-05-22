Visitor v = new Visitor() {
    @Override
    public void visitChildOne(ChildOne child) {
        System.out.println("Visiting child type 1");
        String someProperty = child.getPropertySpecificToChildOne();
    }
    @Override
    public void visitChildTwo(ChildTwo child) {
        System.out.println("Visiting child type 2");
        int someProperty = child.getPropertySpecificToChildTwo();
    }
    @Override
    public void visitChildThree(ChildThree child) {
        System.out.println("Visiting child type 3");
    }
};
for (Parent p: parentClassList) {
    p.accept(v);
}