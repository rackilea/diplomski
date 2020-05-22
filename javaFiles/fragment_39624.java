public class Entity {
    static {
        new Thread(){
            @Override
            public void run() {
                synchronized (getClass().getClassLoader()){
                    try {
                        getClass().getClassLoader().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AtomicReference v = new AtomicReference(new Object());
        Object var = null;
        Object somenew;
        do {
            var = v.get();
            somenew = new Object();
        } while(!v.compareAndSet(var, somenew));
    }

}