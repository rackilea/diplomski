if (filterColour(rgb)){
...
}


// method one predefine a set of colours that are near white
// suitable if you do not have too many colours or colors you want to
// filter are distinct from one another
private boolean filterColour(int rgb){
     return whiteishColours.contains(rgb);
}


//method two convert to HSV then use brightness and saturation to determine
//a zone of colours to filter
//I have not merged the components for this
private boolean filterColour(int r, int g, int b){
    float[] hsv = new float[3];
    Color.RGBtoHSB(r,g,b,hsv);
    return (hsv[2] > 0.9 && hsv.[1] < 0.1);
}