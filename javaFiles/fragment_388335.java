class Base {
    public final void fun1() {
    }

    private void fun2() {
        System.out.println("Base::fun2");
    }

    public void fun2Call() {
        fun2();
    }        
}

class Rextester extends Base
{  
    /*
    @Override
    public void fun1() { // compile error, because Base::fun1 is final
    } 
    */

    // if @Override is uncommented, it will protect you from overriding private methods
    //  otherwise you will not get any compile time error.
    //@Override 
    private void fun2() {
        System.out.println("Rextester::fun2");
    }    

    public static void main(String args[])
    {
        Base b = new Rextester();
        b.fun2Call(); // will output Base::fun2,
                      // if you change private to protected or public 
                      // then you will see Rextester::fun2 in output
    }
}