Random rand = new Random();

for (int i=0; i<width; i++){
    for (int j=0;  j<height ; j++){
        // default color : Black
        int colorToPut = Color.BLACK;

        // If lucky get a white pixel ;)
        if(rand.nextInt(2)==0){
            colorToPut = Color.WHITE;
        }

        // Set color to (i,j) pixel
        randomGridBitmap.setPixel(i,j,colorToPut);
    }
}