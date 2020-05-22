for(int i = 0; i < rows ; i++) {
    for(int j = 0; j < columns ; j++) {
       if(seatingChart[i][j].equals(str)) {
           System.out.print("XX" + " ");
       } else {
           System.out.print(seatingChart[i][j] + " ");
       }
    }
    System.out.println("");
  }