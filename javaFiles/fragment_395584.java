int newWidth  = (int) (this.width * cos + this.height * sin);
int newHeight = (int) (this.width * sin + this.height * cos);

// After setting the new width and height...

// set rotation origin
double rox = this.width/2;
double roy = this.height/2;

// set translation center
double tcx = newWidth/2;
double tcy = newHeight/2;

Bitmap returnMap = new Bitmap(newWidth,newHeight);
returnMap.fill(0xFF000000);
for (int y = 0; y < this.height; y++){

    double yy = y - roy;

    for(int x = 0; x < this.width; x++){

        double xx = x - rox;

        int srcPixel = x + (y * this.width);
        int color= this.pixels[srcPixel];
        if(color>0) continue;

        // following two lines are modified
        int xDstPixel = (int) (xx * cos + yy * sin) + tcx;
        int yDstPixel = (int) (xx * sin - yy * cos) + tcy;

        // prevent negative index : maybe it is not needed at all
        if (xDstPixel<0 || yDstPixel<0)
            continue;

        int dstPixel = xDstPixel + (yDstPixel * newWidth);

        returnMap.pixels[dstPixel]=color;
    }
}