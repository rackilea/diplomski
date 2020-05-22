class Pair<T>
{
    T  var;
   <T> Pair(){}
   <T> Pair(Class<T> reflection){
             var = reflection.newInstance() ;  
             }

   <T> void func(){
   System.out.println(var);
   }
}