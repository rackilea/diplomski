private ColorShape[][] _tiles; 

public GamePanel(int width, int height)
{
   _tiles = new ColorShape[width][height];

   for (int i = 0; i<height; i++){
      for(int j=0; j<width;j++){
          _tiles[j][i] = null;
      }
   }

  for (int j=0; j<width;j++){
        _tiles[j][tiles[j].length-1] = new ColorRectangle(Color.BLACK);

 }
}