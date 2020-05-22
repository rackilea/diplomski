Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run(){
       if (ctx instanceof ConfigurableApplicationContext) {
           ((ConfigurableApplicationContext)ctx).close();
       }
    }
 });