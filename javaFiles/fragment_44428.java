Thread background = new Thread() {
  @Override
  public void run() {

     ... long running background code

     Display.getDefault().asyncExec(new Runnable() {
        @Override
        public void run() {
           .. code accessing user interface objects
        }
     });

     .... more code
  }
};

background.start();