Runtime runtime = Runtime.getRuntime();
try {
    Process p1 = runtime.exec("core.bat");
    Thread t=new Thread(()->{
        try{
            p1.waitFor();
            //your code
        }catch(InterruptedException e){
            Thread.currentThread.interrupt();//not actually needed, but I think it is a good practise and...SonarLint :)
        }
    });
    t.setDaemon(true);
    t.start();
} catch(IOException ioException) {}