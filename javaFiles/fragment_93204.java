public class B extends A<DerivedClass> {
     //..
     void doAction(DerivedClass obj) {
         obj.callMethodAvailableOnlyInDerivedClass();
     }
}