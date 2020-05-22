public static void main(String[] args) {         
    // Create an Array of airplanes
    int size = DATA.length;
    Air[] airplanes = new Air[size];

    for (int i=0; i<size; i++) {
      for (int j=0;j<8;j++) {
        airplanes[i].setAirline(DATA[i][j]);
      }//J-loop
    }//I-loop
 }//main