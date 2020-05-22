public class Exercise_432 {

     public static void main(String[] args) {

       double users = 1; //Assuming it to be 1 Billion.
       double rate = 0.04; 
       int months = 0;

       while(users < 1.5) { //Stops looping if users count is >= 1.5 Billion
           users = users + (users * rate); //total new users = old users + new users for that month
           months++;
           if(users >= 1.5) {
               System.out.println(months);
           }
       }
       while(users < 2) { //Stops looping if users count is >= 2 Billion
           users = users + (users * rate);
           months++;
           if(users >= 2) {
               System.out.println(months);
           }
       }
     }
 }