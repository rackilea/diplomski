public class Worker
{
   private List<? extends Orderable> workingList;

   public void setList(List<? extends Orderable> value) {this.workingList=value;}

   public void changePlaces(Orderable o1,Orderable o2)
   {
     // implementation that make o1.order=o2.order and vice verca  
   }
}