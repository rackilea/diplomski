import java.util.Scanner;

class TauNumber {


    public static void main(String[] args){

        Scanner input =new Scanner(System.in);
        System.out.println("Please enter first number: ");
        int start=input.nextInt();
        System.out.println("Please enter last number: ");
        int stop=input.nextInt();

        for(int i=start+1; i<stop; i++){
            if(refractorable(i)){
                System.out.println("Found tau number: "+ i);
                break;
            }
        }

    }

    public static boolean refractorable(int number){
        if(sumDivisors(number) == 0) return false; 

        if(number % sumDivisors(number) == 0){
            return true;
        } else {
            return false;
        }
    }

    public static int sumDivisors(int number){
        int sum = 0;
        for(int i=1; i<=number; i++){
            if(number % i == 0){
                sum++;
            }
        }
        return sum;
    }


}