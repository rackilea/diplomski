private static Context myContext;
public static Context getInstance() {
    return myContext == null 
       ? myContext = new Context() //it is now assigned
       : myContext;
}