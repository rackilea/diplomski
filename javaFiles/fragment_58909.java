//Initiate color filter
ColorMatrix cm = new ColorMatrix();
float[] matrix = {
    0, 0, 1, 0, 0, //Red (Grabbing blue values)
    0, 1, 0, 0, 0, //Green 
    1, 0, 0, 0, 0, //Blue (Grabbing red values)
    0, 0, 0, 1, 0 //Alpha 
};
cm.set(matrix);
ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);

//Set color filter
p.setColorFilter(f);