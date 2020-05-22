public class PurseTest {

         public static void main(String[] args) {
             String[] coin = { "Quarter", "Dime", "Nickel", "Dime" };
             Purse purse = new Purse();
             purse.addAllCoin(coin);

            System.out.println(purse);
         }

   }

   public class Purse {
            ArrayList<String> data;

            public Purse() {
              data = new ArrayList<String>();

            }

           public void addAllCoin(String[] strArr) {

              for (String s : strArr) {
                  data.add(s);
              }

            }

           @Override
           public String toString() {
               Collections.reverse(data);
               return data.toString();
           }

   }