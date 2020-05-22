public class ArrayExpander
{
   private int size;
   private int noOfItems;
   private Object[] store;
   private final int INITIALSIZE = 2;

   public ArrayExpander()
   {
      store = new Object[INITIALSIZE];
      noOfItems = 0;
      size = INITIALSIZE;
   }

   public void add(Object obj)
   {
      growBufferIfNecessary();
      store[noOfItems++] = obj;
   }

   public String toString()
   {
      String temp = "[" + store[0];
      for (int i = 1; i < size; i++)
      {
          temp = temp + "," + store[i];
      }
      temp = temp + "]";
      return temp;
   }
   private void growBufferIfNecessary()
   {
      if (noOfItems == size)
      {
         size = 2 * size;
         Object[] newStore = new Object[size];
         for (int i = 0; i < store.length; i++) 
         { 
            newStore[i] = store[i]; 
         }      
         store = newStore;
      }
   }
   public static void main(String[] args)
   {
      ArrayExpander ae = new ArrayExpander();
      //System.out.println(ae);
      ae.add("a");
      ae.add("b");
      System.out.println(ae);
      ae.add("c");
      ae.add("d");  
      ae.add("e");
      ae.add("f");
      ae.add("g");
      ae.add("h");  
      System.out.println(ae);
      ae.add("i");
      System.out.println(ae);
   }
}