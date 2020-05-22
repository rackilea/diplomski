Runtime.getRuntime().addShutdownHook( new Thread() { 
    @Override 
    public void run() { 
        System.out.println("Application shutdown"); 
    }
});