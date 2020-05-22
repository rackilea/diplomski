abstract class MainClass{
    abstract Class<? extends BaseClass> onCreateClass(); <-- all classes extends BaseClass
}

class ChildClass extends MainClass{
    @Override
    Class<AnotherClass> onCreateClass() { <-- compilation valid
        return AnotherClass.class;
    }
}


class AnotherClass extends BaseClass {

}

private class BaseClass {
}


class SecondChildClass extends MainClass{
    @Override
    Class<SecondAnotherClass> onCreateClass() { <-- compilation failed
        return SecondAnotherClass.class;
    }
}

private class SecondAnotherClass {
}