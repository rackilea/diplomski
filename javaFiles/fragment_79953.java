// AbstractClassA looks like ClassA above; it contains addOnce
class ClassA extends AbstractClassA<ClassA> {
    @Override
    public ClassA self() {
        return this;
    }
}

class ClassB extends AbstractClassA<ClassB> {
    ClassB addTwice(String s2) {
        ...
        return this;
    }
}