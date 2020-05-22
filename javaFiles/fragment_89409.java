class Service1 {
    public List<Impl1> service1Impl(){
        SomeOtherClass<Impl1> obj = new SomeOtherClass<>(...);
        return obj.foo();
    }
}

class Service2 {
    public List<Impl2> service2Impl(){
        SomeOtherClass<Impl2> obj = new SomeOtherClass<>(...);
        return obj.foo();
    }
}