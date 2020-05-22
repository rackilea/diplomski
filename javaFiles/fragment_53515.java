for (int row = 0; row < getRows(); row++) {
     for (int column = 0; column < getSeatsPerRow(); column++) {
         if (isAvailable(row, column)) {
             System.out.println("Sear " + row +", " + column + " is emply!!!!!!");
         }
     } 
 }