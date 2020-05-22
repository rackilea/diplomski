class AllListener{
    List<Listener> listeners;

    private interface Wrapper {
      public void run(Listener l);
    }

    void onStart(){
        loop(new Wrapper(){
           public void run(Listener l) {
              l.onStart();
           }); 
    }

    void onEnd(){
        loop(new Wrapper(){
           public void run(Listener l) {
              l.onEnd();
           }); 
    }

    private void loop(Wrapper w) {
       for(Listener l:listeners) 
            w.run(l);
    } 
 }