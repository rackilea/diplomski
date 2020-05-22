if(thisTileHasBeenClicked){

   //if the tile has been clicked on
   g2d.setColor(Color.green);
   g2d.fill(square);
}else{

   //if the tile has not been clicked on
   g2d.setColor(Color.gray);
   g2d.fill(square);
}