public class SampleClass 
{
    int a;
    int b;
    ExtraClass extraClass;
    static int c;

    public SampleClass() 
    {
        super();

        // Variable initializers.
        this.a = 10;
        this.b = 11;
        this.extraClass = new ExtraClass();

        // Explicit instance initializer.
        {
          //  IIB
          System.out.println(a);
          System.out.println(b);  
          System.out.println(extraClass);         
        }

        //  call to IIB
        System.out.println("===============");
        System.out.println(a);
        System.out.println(b);
        System.out.println(extraClass);             
    }

    public static void main(String[] args) 
    {
        SampleClass obj = new SampleClass();
    }
}