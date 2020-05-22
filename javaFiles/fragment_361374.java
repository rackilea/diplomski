//Find out which tiles to draw based on the camera position and viewport size.
    int startX = (int)(camera.position.x - camera.viewportWidth / 2) / tileWidth;
    int startY = (int)(camera.position.y - camera.viewportHeight / 2) / tileHeight;
    int endX = (int)(startX + camera.viewportWidth / tileWidth) + 1;
    int endY = (int)(startY + camera.viewportHeight / tileHeight) + 1;

    //Loop using this data as boundaries 
    for (int y = startY; y < endY; y++)
    {
        for (int x = startX; x < endX; x++)
        {
            //If out of bounds continue to next tile.
            if (!tileExists(x, y, map) continue;
            //Now all we need to draw the on screen tiles properly:
            //x == tile position x in array
            //y == tile position y in array
            //World position of this tile:
            //worldX = x * tileWidth;
            //worldY = y * tileHeight;
            //Let's draw:
            batch.draw(map[x][y].getTexture, worldX, worldY,
             tileWidth, tileHeight)
        }
    }