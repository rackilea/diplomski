public class Foo 
{
   public static void main(String[] args)
    { 
    int x[] = new int[5];
    for(int i=0;i<5;i++)
        x[i]=i*i;

    for(int i=0;i<5;i++)
        {
            System.out.println("Value # " + (i+1) + " = " + x[i]);
        }
    }
}