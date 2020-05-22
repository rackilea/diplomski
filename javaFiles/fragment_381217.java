public class Main {
    public static void main(String[] args) {
         int houseMoney;
         String input;
         input = System.console().readLine("How much money do you have? > ");

         houseMoney = Integer.parseInt(input);

         if (houseMoney <= 250000 && houseMoney >= 100000) {
             input = "You can afford a Townhouse!";
         } else if(houseMoney >= 250001 && houseMoney <= 400000) {
            input = "You can afford a Single Family House!";
         } else if (houseMoney >= 400001 && houseMoney <= 800000) {
            input = "You can afford a Luxury House!";
         } else if (houseMoney >= 800001) {
            input = "Wow! You can Afford a mansion!";
         } else {
            input = "You can't afford a house!";
         }

        System.out.println(input);
    }
}