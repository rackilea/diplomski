import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
    float charSum=0;

            Scanner myObj = new Scanner(System.in);

            System.out.println("Please enter a string");
            String input1 = myObj.nextLine();
            char[] arr=input1.toCharArray();
            for(int i=0;i<arr.length;i++){
               int ascii=(int)arr[i];

               if(ascii>=97&&ascii<=122){
                charSum=charSum+ascii-96; //for a-z
               } 
                else if(ascii>=65&&ascii<=90){
                charSum=charSum+ascii-64;  //for A-Z
                }
                else if(ascii>=48&&ascii<=57){
                     charSum=charSum+ascii-48;  //ascii for number
                }else{
                     charSum=charSum+0;  //ascii for special Character
                }
            }

            System.out.println("Please enter a Integer");
            int integerValue = myObj.nextInt();
            charSum+=integerValue;

            System.out.println("Please enter a Double");
            Double doubleValue = myObj.nextDouble();
            charSum+=doubleValue;

            System.out.println(charSum);

    }
}