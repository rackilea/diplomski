public class Singleton {
    public static Singleton instance; //field is made public so we can print it from main class (just to debug)
    static int k;


    public static Singleton getInstance(){
        try{
            instance = new Singleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
        return instance;
    }

    public static void main(String[] ar) {
        Singleton c1=Singleton.getInstance();
        c1.k=1;
        Singleton c2=Singleton.getInstance();
        c2.k=2;

        //notice that both of the instance variables of c1 and c2 are printed
        //after we've initialized all of them.
        System.out.println(c1.instance);
        System.out.println(c2.instance);

        System.out.println(c1.k);
        System.out.println(c2.k);

    }
}