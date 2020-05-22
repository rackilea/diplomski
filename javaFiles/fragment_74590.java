int baser = 108; //base red 
int baseg = 96;  //base green
int baseb = 68;  //base blue
int range = 10;  //threshold + and - from base values

/* Set all pixels within +- range of base RGB to black */
for (int i = 0; i < pixels.length; i++) {
        int a = (pixels[i]>>24)     &0xFF; //alpha
        int r = (pixels[i]>>16)     &0xFF; //red
        int g = (pixels[i]>>8)      &0xFF; //green
        int b = (pixels[i]>>0)      &0xFF; //blue

        if ( (r > baser-range && r < baser+range) && 
             (g > baseg-range && g < baseg+range) && 
             (b > baseb-range && b < baseb+range) ) {
                pixels[i] = 0xFF000000; //Set to black
        }
}