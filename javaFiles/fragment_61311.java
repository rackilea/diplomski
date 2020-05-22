public class firstprog {


    public static int largest(int a,int b,int c) 
    {
        if(a>b)
        { 
            if(a>c)
                return a;
            else 
                if(b>c)
                    return b;
                else 
                    return c;
        }
        else
        {
            if(b>c)
                return b;
            else 
                return c;
        }
    }   

    public static  void main(String args[]) {

        int a=19;
        int b=2;
        int c=1;

        System.out.println(largest(a,b,c));  
  }
}