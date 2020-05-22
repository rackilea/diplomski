class PrintMyObjectsVisitor implements MyObjectsVisitor {

    public void visit (MyInteger i) {
        System.out.println( "Integer: " + i.get() );
    }

    public void visit (MyString s) {
        System.out.println( "String: " + s.get() );
    }

    public void visit (MyObject o) {
        System.out.println( "Object: " + o.get() );
    }
}