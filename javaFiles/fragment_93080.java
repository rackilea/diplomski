class Base {

     void someMethod() {
         int value = getValue();

         // calculate something
     }

     protected abstract int getValue();
}

class Derived extends Base {

    int getValue() {
         return 5;
    }
}