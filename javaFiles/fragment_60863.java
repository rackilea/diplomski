class Base
{
    public Base(int x){
        //some statements
    }
    /*
       some methods
    */
}

class Derived
{
    // only one of the following will be used
    public Derived(){  // This will cause a compile-time error
      //some statements
    }
    public Derived(){  // This will work fine
     //some statements
        super(x);
    }
    /*
      some methods
    */
}