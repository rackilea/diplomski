class SomeOtherClass {
    Stuff stuff;
    class Me {
        void method(){
            // I can access the instance variables of the outer instance 
            // like this:
            System.out.println(SomeOtherClass.this.stuff);
            // Just avoid using a non-static nested class unless you 
            // understand what its use is!
        }
    }
}