static class Outputer {
    private static Object syncronisationMonitor = new Object();

    // nonstatic method
    public void outPut( String name) {          
        synchronized (syncronisationMonitor ) { // we use the same monitor as in the static method                        
           [...]
        }
    }

    //static method
    public static void outPut3( String name) {    
        synchronized (syncronisationMonitor ) {  // we use the same monitor as in the non-static method                                               
            [...]
        }
    }
}