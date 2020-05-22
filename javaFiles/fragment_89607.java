import java.util.Random;

public class Dice {

    public static  int rollDice(int number, int nSides)
    { 
        int num = 0;
        int roll = 0;
        Random  r = new Random(); 
        if(nSides >=3) 
        { 
            for(int i = 0; i < number; i++)
            { 
                roll = r.nextInt(nSides)+1;
                System.out.println("Roll is:  "+roll);
                num = num + roll; 
            } 
        } 
        else
        { 
            System.out.println("Error num needs to be from 3"); 
        } 
        return num;  
    } 

    public static void main(String[] args)
    {
        System.out.println("Total is: "+rollDice(3, 6));
    }
}
/*
Roll is:  4
Roll is:  1
Roll is:  2
Total is: 7
*/