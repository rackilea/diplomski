class ValueListInner extends AbstractList<Value> {
    public ValueListInner(ValueList list) {
        javassist_write_this_outer(list);
        super();    
    }

    private void javassist_write_this_outer(ValueList list) {
        //...
    }
}