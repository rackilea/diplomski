import static java.lang.System.*;
import java.util.*;
class Life 
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(in);
        int count;
        for(count=0;count>=0;count++)
        {
            int num=input.nextInt();
            if(num==42)
            {
                break;
            }
            else
            {
                out.println(num);
            }
        }
    }
}