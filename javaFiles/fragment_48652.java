public final class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton(){
        if(instance!=null)
            throw new RuntimeException();
    }

    public static final DoubleCheckedLockingSingleton getInstance(){
        if(instance==null){
            synchronized(DoubleCheckedLockingSingleton.class) {
                if(instance==null)
                    instance = new DoubleCheckedLockingSingleton();
            }
        }
        return instance;
    }

}