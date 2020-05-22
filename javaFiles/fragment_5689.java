public class Association{
   private Map<MyDevice, MyThread> map;

   public MyThread add(MyDevice device){
      MyThread t = new MyThread(device);
      map.put(device, t);
       return t;
   }

   public void stopThread(final Device d){
      final Thread t = map.get(d);
      if(t != null && t.isAlive()){
         new Thread( () -> {
            t.interrupt();
            try{ t.join(); }
            catch(InterruptedException ex){}
         }).start();

         map.remove(d);
      }
   }

   ... // Constructor, thread getter, remove logic, sorting...
}