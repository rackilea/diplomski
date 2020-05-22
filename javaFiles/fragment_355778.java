public void scope1(){
    if (something){
        int myint = 1;
        // possibly some other code here...
    }
    System.out.println(myint); // This will not compile, myint is not known in this scope!
    int myint = 1; // Declare myint in this scope
    System.out.println(myint); // now it works.
}