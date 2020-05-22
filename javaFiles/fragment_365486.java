public void square_Block(int color) { //Horizontal || Vertical || Colour

    //Horizontal never changes for this as I just want the blocks to go down.
    a[0][verticalPos] = color;
    a[0][verticalPos1] = color;
    a[1][verticalPos] = color;
    a[1][verticalPos1] = color;
}