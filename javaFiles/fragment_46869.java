public Point pointOnEdge(int width, int height) {
    int side = (int) (Math.random() * 3); //0=top, 1=bot, 2=left, 3=right

    int x = 0;
    int y = 0;

    switch(side) {
    case 0:
        //when on top, y is at the top of the image (0) and x is something in [0, width]
        y = 0;
        x = (int) (Math.random() * width);
        break;
    case 1:
        //when on bottom, y is at the bottom of the image (image height) and x is something in [0, width]
        y = height;
        x = (int) (Math.random() * width);
    case 2:
        //when on left, x is at the left side (0) of the image and y is something in [0, height]
        y = (int) (Math.random() * height);
        x = 0;
        break;
    case 3:
        //when on left, x is at the left side (0) of the image and y is something in [0, height]
        y = (int) (Math.random() * height);
        x = width;
        break;
    }

    return new Point(x, y);
}