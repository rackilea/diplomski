public class ListHolder <x>
{ 
    List<x> list ;     
    public  void print (List<x> list2, int count) 
    {      
        list= list2;
        for (int i = 0; i < count;  i++) 
        {
            System.out.print(list2.get(i)+"\n");
        }
    } // end print
} //end class