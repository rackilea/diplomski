class MyClass {
    val x = 3;
}

object MyClass {
    val y = 10;
}

type C = MyClass // now C is "class MyClass", not "object MyClass"
val myClass: C = new MyClass() // Correct
val myClassY = MyClass.y // Correct, MyClass is the "object MyClass", so it has a member called y.
val myClassY2 = C.y // Error, because C is a type, not a singleton object.