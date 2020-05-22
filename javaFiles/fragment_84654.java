ExecutorService e = Executors.newFixedThreadPool(5);
    public void test(final Map<Object,Object> map){
       for(int i =0; i < 5000; i++){
           e.submit(new Runnable(){
               public void run(){
                    map.put(new Object(),new Object());
               } 
           });
       }
    }

test(new HashMap<Object,Object>()); //will probably go into an infinite loop
test(new ConcurrentHashMap<Object,Object>()); //will *never* go into an infinite loop