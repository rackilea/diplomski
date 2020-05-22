public class Test { 
   private int numberOfShips = 400;
   private int count;

   public ArrayList<Ship> createFleet(int choice) {
       ArrayList<Ship> fleet = new ArrayList<Shipe>();
       if(count < numberOfShips) {
         if(choice > 0 && choice < 5) {
            //appropriate ship..
         }
       } else {
          System.out.prinln("Capactity reached");
       }  
   }
}