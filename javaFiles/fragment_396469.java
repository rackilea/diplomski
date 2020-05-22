import java.io.*;
import java.util.Random;

public class Lottery{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random rn = new Random();

        int ch = 1;
        while(ch == 1){
            String str = "";
            String str1 = "";
            String str2 = "";

            for(int i = 0; i < 3; i++){
                int answer1 = rn.nextInt(9) + 1;

                //delay(2000);
                str = str + "-" + answer1;
                str1=str1+answer1;
            }

            System.out.println(str);
            str = "";

            for(int i =0; i < 3; i++){
                int answer1 = rn.nextInt(9) + 1;

                //delay(2000);
                str = str + "-" + answer1;
                str2 = str2 + answer1;
            }
            System.out.println(str);

            if(Integer.parseInt(str1) == Integer.parseInt(str2)){
                System.out.println("Crongrats !! You are the Lucky Winner !!!!");
            }   
            else
                System.out.println("Better Luck Next Time");

            System.out.println("Wanna Try Again ? 1=YES, 0=NO");
            ch = Integer.parseInt(br.readLine());
        }
        System.out.println("Thanks for Playing Lottery with us !! Come back soon");
    }
}