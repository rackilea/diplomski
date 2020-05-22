// lazy initialization
public class Singleton
{
//initailzed during class loading
private static final Singleton INSTANCE;

//to prevent creating another instance of Singleton
private Singleton(){}

public static Singleton getSingleton(){
    // object will be initialized on it's first call.
    if(INSTANCE == null)
        INSTANCE = new Singleton();
    return INSTANCE;
}
}