final int tile_size = 30;

final RectangleType displayWindow = Forgotten.getDisplayWindow ();

final int left = displayWindow.getLeft () / tile_size - 1;
final int right = displayWindow.getRight () / tile_size + 1;
final int top = displayWindow.getTop () / tile_size - 1;
final int bottom = displayWindow.getBottom () / tile_size + 1;

for (int y = top; y < bottom; ++y)
   for (int x = left; x < right; ++x)
       canvas.drawImage (LevelGen.getBlockAt (x,y).getTexture (),
                         x * tile_size, y * tile_size);