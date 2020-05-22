Class A{
    int i;
    static int j;

    public static void methodA(){
        i = 5; //cannot use since i is not static
        j = 2; //can use.

        int k = 3; //k is local variable and can be used no problem

        **EDIT:**//if you want to access i
        A a = new A();
        //A.i = 5; //can use.  
        a.i = 5; // it should be non-capital "a" right?
    }
}