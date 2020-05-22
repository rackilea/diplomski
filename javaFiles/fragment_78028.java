private MyTest() throws UniAppException { // Better if you declare _which_ exception UniApp throws!
    // If you want your own code to log what happens, keep the try/catch but rethrow it
    try{                        
        uniApp = new UniApp("test","test123");          
    }
    catch(UniAppException e) {
        e.printStackTrace();
        logger.error("Exception " +e+ "occured while creating instance of uniApp");
        throw e;
    }   
}

public static MyTest getInstance() throws UniAppException {
    if (test == null) {
        synchronized(MyTest.class) {
            if (test == null) {
                test = new MyTest();
            }
        }
    }
    return test;
}