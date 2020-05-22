public class Errors {

    public static void main(String[] args) {

        System.out.println("Welcome to my first program!\n");

        String ageStr = "24";                           //24years is wrong input, enter only 24

        int age = Integer.parseInt(ageStr);

        System.out.println("I'm " + age + " years old.");

        String three = "3";
        int ageToString = Integer.parseInt(ageStr);
        int threeToString = Integer.parseInt(three);
        int answerYears = ageToString + threeToString;

        System.out.println("Toal number of years: " + answerYears);

        int answerMonths = answerYears * 12 + 6;                //you forgot to add 6 months

        System.out.println("In 3 years and 6 months, I'll be " + answerMonths + " months old");

        // Once you've corrected all the errors, the answer should be 330.
    }

}