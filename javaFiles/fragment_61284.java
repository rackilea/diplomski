import java.util.Scanner;
public class problem2try {

    public static void main(String[] args) {
        //declarations 
        Scanner keyboard = new Scanner (System.in);  
        int [] inputList = new int [10]; 
        int [] distinctArray = new int [10]; 
        int num; 
        int counter = 0; 

        //input 
        System.out.print("Please enter in 10 integers: ");

        for (int i = 0; i < inputList.length; i++)
        {
            num = keyboard.nextInt(); 
            inputList[i] = num; 
        }

        //processing
        for (int i = 0; i < inputList.length; i++)
        {
            boolean found = false;
            for (int j = 0; j < counter; j++)
            {
                if (inputList[i] == distinctArray[j])
                {
                    found = true;
                    break;
                }
            }
            if (!found)
            {
                distinctArray[counter++] = inputList[i];
            }
        }

        //output
        System.out.println("The number of distinct numbers is " + counter);
        System.out.print("The distict numbers are: ");
        for (int x=0; x<counter; x++)
        {
            System.out.print(distinctArray[x] + " ");
        }
    }
}