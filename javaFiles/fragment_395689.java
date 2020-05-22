class UncaughtExceptionLogger implements Thread.UncaughtExceptionHandler {
    @Override
    void uncaughtException(Thread t, Throwable e) {
        //TODO do some logging;
        println "test";
    }
}

def main(){
    Thread.defaultUncaughtExceptionHandler = new UncaughtExceptionLogger()
    String s;
    s.charAt(10); // causes a NullPointerException but the exception handler is not called
}

Thread.start {
  main()
}