open class Base {
    class Nested
}

class Derived : Base()

val base = Base.Nested::class        // OK
val derived = Derived.Nested::class  // Error: 'Nested' unresolved