shapeRenderer.begin();
 for(int x = 0; x < rows; x++){
     for(int y = 0; y < columns; y++){
         gridSquares[x][y].drawOutLine(shapeRenderer);
     }
 }
 shapeRenderer.end();


 spritebatch.begin();
 for(int x = 0; x < rows; x++){
     for(int y = 0; y < columns; y++){
         // Assuming you have loaded the png image into a variable named balltexture
         gridSquares[x][y].drawImage(spritebatch, balltexture);
     }
 }
 spritebatch.end();