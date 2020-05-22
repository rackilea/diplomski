package test;

import java.util.ArrayList;

public class Theatre {
   //Number of rows in the theatre
   public static final int NUMBER_ROWS = 10;
   //Number of seats that are in each row
   public static final int NUMBER_OF_SEATS_IN_ROW = 15;
   ArrayList<ArrayList<Integer>> seat = new ArrayList<ArrayList<Integer>>();

   public Theatre(){
        for(int x=0; x<NUMBER_ROWS;x++){
            ArrayList<Integer> arrSeat = new ArrayList<Integer>();
            for(int y=0;y<NUMBER_OF_SEATS_IN_ROW; y++) {
                if(x<5){ // If row is less than 5, set price of seat to 100
                    arrSeat.add(100);
                }else{ // If row is not less than 5, set price to 70
                    arrSeat.add(70);
                }
            }
            seat.add(arrSeat);
        }
    }

    /**
     * This method displays all the seats and gives a visual representation     of which seats are reserved
     */
    public void showReservations(){
         String output = "";
         for(int x=0;x<NUMBER_ROWS;x++){
             for(int y=0;y<NUMBER_OF_SEATS_IN_ROW;y++){
                 if(x==2 && y==3 || x==5&&y==2 || x==4&&y==4) {
                     seat.get(x).set(y, 0);
                 }
                 if(seat.get(x).get(y) == 0) {
                     output += " x ";
                 } else {
                     output += " o ";
                 }
             }
             output += "Row "+(x+1)+"\n"; // Append newline character when row is complete
          }
          System.out.println(output);
      }

      public static void main(String[] args) {
          Theatre theatre = new Theatre();
          theatre.showReservations();
     }
}