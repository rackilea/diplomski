$cat Funky.java  
class Funky {
}
class FunkySubClass extends Funky { 
}
class SomethingElse { 
}
class SomeClass extends SomethingElse { 
    private Funky aFunkyVar;
    //...
    public void noNeedToCast() { 
        aFunkyVar = new FunkySubClass();
    }
}

$javac Funky.java 
$