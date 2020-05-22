int[] xNumbers = { x1, x2, x3, ... x10 };
int[] countup = new int[10];

//Set the 0 index so we don't have to do extra check inside the for loop
//for out-of-bounds exception
countup[0] = xNumbers[0];
for (int i = 1; i < 10; i++) {
    //countup[i-1] is why we set index 0 outside of the loop
    countup[i] = xNumbers[i] + countup[i-1];
}