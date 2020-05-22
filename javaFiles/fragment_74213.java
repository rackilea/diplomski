//initialized Foo library
private native synchronized int fooLibInit();

//start the process 
public native synchronized int fooStart(String message);

//continue the process after a delay 
public native synchronized int fooContinue(String message);

//retrieve milliseconds to schedule next event
public native synchronized long fooGetMsToNextEvent();

//method that gets called from native code
public static synchronized long getCurrentTime(){
    return System.currentTimeMillis();
}

//method that gets called from native code, returning results
public static synchronized void deliverResult(String result){
    //display result to the user
}