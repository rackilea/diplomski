Graphics g = //initialize graphics;
Image yourTileImage = //load your image;
for (int xpos = 0; xpos < maxX; xpos++)
    for (int ypos = 0; ; ypos < maxY; ypos++)
        int number = //get number from map file
        g.drawImage(Image yourTileImage,
            xpos * 16, ypos * 16, xpos * 16 + 15, ypos * 16 + 15,
            number*16, 0, number+15, 15,
            ImageObserver observer)