import java.util.Scanner; 
public class AsteriskGenerator { 
    public static void main(String[] args){ 

    AsteriskGenerator asteriskGenerator = new AsteriskGenerator(); 

    int nb[]=new int[5];
    Scanner input = new Scanner (System.in); 
    for(int i=0;i<5;i++)
    {
        System.out.print("Please, Enter a number between 1 - 30 "); 
        nb[i]=input.nextInt();
    }
    input.close();


    asteriskGenerator.asteriskGenerator(nb);
    } 
    void asteriskGenerator(int nb[])
    { 
        for(int i = 0; i <  nb.length; i++)
        {
            for(int j=1;j<=nb[i];j++)
            {
                System.out.print("*"); 
            }
            System.out.println(); 
        } 
    } 

}