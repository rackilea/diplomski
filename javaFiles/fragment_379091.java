public class Factoring {
    public static void main(String[] args) {
        int number = 15;
        int factorNumber = 1;

        while(factorNumber <= number){
            if(number % factorNumber == 0){
                System.out.println(factorNumber + " is a factor of " + number);
            }
            factorNumber ++;
        }
    }
}