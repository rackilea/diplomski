class Scratch {
    public static void main(String[] args) {

        ImplementedClass implementedClass = new ImplementedClass();

        ClassA clsA = new ClassA();
        implementedClass.myMethodFromClassA(clsA);
    }

}

class ImplementedClass implements MyInterface<ClassA> {
    @Override
    public void myMethod() {

    }

    @Override
    public void myMethodFromClassA(ClassA c) {
        System.out.println(c.getTwo());
    }
}

class ClassA {
    public Integer getTwo() {
        return 2;
    }
}

interface MyInterface<T> {
    void myMethod();

    void myMethodFromClassA(T c);
}