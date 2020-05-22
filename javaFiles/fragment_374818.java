// eager loading of INSTANCE    
public class Singleton
{
//initailzed during class loading
private static final Singleton INSTANCE = new Singleton();

//to prevent creating another instance of Singleton
private Singleton(){}

public static Singleton getSingleton(){
    return INSTANCE;
}
}