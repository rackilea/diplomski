private static Image[][] parseIntArray( int[] array )
{
    Image[][] layer = new Image[WIDTH][HEIGHT];

    for (int x = 0; x < WIDTH; ++x)
        for (int y = 0; y < HEIGHT; ++y)
            layer[x][y] = getSpriteImage( array[ y * WIDTH + x ] );

    return layer;
}