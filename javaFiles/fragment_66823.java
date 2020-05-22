public class C
{
   private int num = 4;
   private int[] a = new int[5];

   public int[] geta()
   {
       int[] arr = new int[a.length];
       System.arraycopy(a, arr, 0, a.length)
       return arr;
   }
}

public class Foo
{
   .
   .
   .
   C c = new C();
   int[] nums = c.geta();
}