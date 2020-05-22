public class Main implements CustomObjectVisitor {
    public void methodThatDidntWorkBefore() {
        ArrayList<CustomObject> list = new ArrayList<>();
        for(CustomObject obj: list) {
            obj.accept(this);
        }
    }

    @Override public void visitA(CustomObjectA a) { ... }
    @Override public void visitB(CustomObjectB b) { ... }
}