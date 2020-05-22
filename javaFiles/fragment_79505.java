abstract class AbstractClass<I extends Item, V extends AbstractClass<I, V>.Inner> {
    abstract class Inner {
        I item;
    }
}

class ImpClass extends AbstractClass<Page, ImpClass.Inner> {
    abstract class Inner extends AbstractClass<Page, Inner>.Inner {
        void method(){
             // Setup item
             // Printout class of item, which is Page
             item.callMethodOfPage(); // compiles
        }
    }
}