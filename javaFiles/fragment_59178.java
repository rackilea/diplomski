public class AdapterForT1 implements MyAdapter{

    private T1 adapted;
    public AdapterForT1(T1 adapted){
      this.adapted = adapted;
    } 

    public void process(){
       adapted.doSomething();
    }

}