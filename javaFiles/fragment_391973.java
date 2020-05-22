public class cinema_seats {
  public static void main(String[] args){

    String[][] seats = new String[20][10];  

      String seat = "abcdefghijklmnopqrstuvwxyz";

      for(int row=0; row<seats.length; row++){
          for(int column=0; column<seats[row].length; column++){    
            seats[row][column] = new String (Character.toString(seat.charAt(column))); 
          }
      }

      for(int row=0; row<seats.length; row++){
          System.out.print("row: " + (row + 1) + " ");
          for(int column=0; column<seats[row].length; column++){                
              System.out.print(seats[row][column] + " ");        
          }
          System.out.println();           
      }
  }

}//main