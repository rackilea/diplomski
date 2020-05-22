public class FilterFactory{
   static{
     HashMap<Integer, Filter> filterMap = new HashMap<>();
     filterMap.put(0,new Filter0());
     ...
   }
   // this function will change depending on your needs
   public Filter getFilter(int processingFunction){
       return filterMap.get(processingFunction);
   }

}