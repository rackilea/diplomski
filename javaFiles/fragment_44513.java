public class Singleton  {    
    private static class Holder {    
        public static final Singleton INSTANCE = new Singleton();
    }    

    public static Singleton getInstance() {    
        return Holder.INSTANCE;    
    }    
}