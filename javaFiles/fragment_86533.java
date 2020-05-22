int[] xArray = new int[8];
int[] yArray = new int[8];
for (int i = 0; i < 8; i ++) {
   xArray[i] = //some value for the x co-ordinate of the ith point
   yArray[i] = //some value for the y co-ordinate of the ith point
}
ShavedBrick b = new ShavedBrick(xArray, yArray, 8);
myBricks.add(b); //finally add the new shaved brick