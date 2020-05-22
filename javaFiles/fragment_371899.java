public class CallableImpl implements Callable<String> {
       private Callable action;
       private int key;
     public CallableImpl (Callable action,int key){
          this.action=action;
          this.key=key;
        }
        @Override
        public String call() throws Exception {
          return  action.call();
        }
    public int getId(){
     return key;
}