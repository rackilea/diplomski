public class project1 {

    public static void main(String[] args) {
        int number = 0;
        int total = 0;

        while (number < 10) {
            System.out.println(number);

            if ((number % 3) == 0) {
                System.out.println(number + " is a multiple of 3");
                total = total + number; 
            }
            else if ((number % 5) == 0) {
                System.out.println(number + " is a multiple of 5");
                total = total+number;   
            }
            number++;
        }
        System.out.println("total = "+ total);
    }
}