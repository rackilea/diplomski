Something s = new Something();

 Thread a = new Thread() {
    public void run(){
       s.add( "s" );
       s.add( "s" );
       s.add( "s" );
     }
 };
 Thread b = new Thread(){
     public void run() {
         s.count();
         s.count();
     }
 };

 a.start();
 b.start();