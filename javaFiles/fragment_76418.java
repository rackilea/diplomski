public class Singleton {

    private static Singleton instance;

    private String a;
    private String b;

    private Singleton(){}

    private Singleton(String a, String b) {
         this.a = a;
         this.b = b;
    }

    public static Singleton getInstance(String a, String b){
        if (instance == null)
            instance = new Singleton(a, b);
        return instance;
    }

}