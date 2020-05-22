public class Manager {

 public enum Dimension{
    WIDTH(700),
    HEIGHT(700);
   private final Integer value;

   Dimension(Integer value){
      this.value=value;
   }

   public Integer getValue(){
       return value;
   }
 }

}