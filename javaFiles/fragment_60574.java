public final class ChildClass extends ParentClass {
    public void method() {
        String value = stringList.get(0);
    }
}

class ParentClass<T> extends NonGenericGrandParent {
}

class NonGenericGrandParent {
    protected final List<String> stringList = new ArrayList<String>();
}