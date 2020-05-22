for (row = 0; row <tuiles; row++) {
   for (column= 0; column<tuiles; column++) {
      if(clicked){

         //check if the click x position is within the bounds of this tile
         if(column * tileWidth + tileWidth > xClick && column * tileWidth < xClick){

            //check if the click y position is within the bounds of this tile
            if(row * tileHeight + tileHeight > yClick && row * tileHeight < yClick){
               //mark this tile as being clicked on.
               clicked = false;
            }
         }
      }
   }
}