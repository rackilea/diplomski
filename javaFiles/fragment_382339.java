public Board(){
  //setup board with null values
  battleShip = new Ship[5][5]; //<----------  now member variable is initialed

  // initialize
  for (int r=0; r < 5; r++ )
       for (int c=0; c < 5; c++ )
        battleShip[r][c]= new Ship();

}