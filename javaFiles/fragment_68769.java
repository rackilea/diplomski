class A <T extends List<?>>{
    void someFunc(T t) {
        t.add(new Object());//compilation error
    }

}

class B <T extends List>{
    void someFunc(T t) {
        //compiles fine
        t.add(new Object());
        t.add("string");
        t.add(new Integer(3));
    }
}