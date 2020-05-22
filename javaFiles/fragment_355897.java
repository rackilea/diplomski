new Thread(new Runnable() {
   @Override    
    public void run() {
       org.example.MainProgram.main(new String[]{"arg0", "arg1", "arg2"})
    }
}).start();