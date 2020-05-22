private int indexPos = 0;

public ArrayList<Box> seekBoxPerLine() {
    //... as above
    indexPos = 0;
}

public void onClick(View view) {
    if (view == btNextBox) {
        indexPos = indexPos + 1;
        //... do whatever you need to do
    }
}