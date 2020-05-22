import java.util.Scanner;


public class lab {
    public static void main(String[] args){

        int StarsN;
        Scanner input;
        input=new Scanner(System.in);

        System.out.println("How many starts do you need ?");
        StarsN= input.nextInt();

        int loopEnd = StarsN;
        int loopStart;
        for (loopStart = 0;loopStart<loopEnd;loopStart++) {
            System.out.print("*") ;
        }

    }

}