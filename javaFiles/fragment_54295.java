class SomeExtendingClass extends SomeClassWithSomeInterface {}
class SomeOtherExtendingClass extends SomeClassWithSomeInterface {}

class Test {
    public static void main() {
        GenericClass<SomeExtendingClass> generic1 = new GenericClass<SomeExtendingClass>();
        generic1.set(new SomeExtendingClass()); // ok
        generic1.set(new SomeOtherExtendingClass()); // error (as expected)

        GenericClass generic2 = new GenericClass<SomeExtendingClass>();
        generic2.set(new SomeExtendingClass()); // ok
        generic2.set(new SomeOtherExtendingClass()); // ok (but shouldn't be!)
    }
}