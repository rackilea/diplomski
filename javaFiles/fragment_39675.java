public class MyClass extends Runnable{
   static ThreadLocal<List<String>> listBonds = new ThreadLocal<List<String>>();

   public MyClass (List<String> list){
        listBonds.set(list);
   }
   public void run(){
      listBonds.get(); // it returns null here?
   }

}