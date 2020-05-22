public class Derived extends Base {
    @Override
    public Derived chainedMethodA(){

         super.chainedMethodA();
         //some stuff
        return this;
    }

    public Derived chainedMethodB() {
        // some stuff
        return this;
    }
}