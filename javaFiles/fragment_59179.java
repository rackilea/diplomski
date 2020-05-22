public class AdapterForT2 implements MyAdapter{

    private T2 adapted;
    public AdapterForT2(T2 adapted){
      this.adapted = adapted;
    } 

    public void process(){
       adapted.doOtherThing();
    }

}