int yPointer = 7;
int xPointer = 3;
int shadePtr = 8;

for (int j = 0; j <= 299; j++) {
    ...
    if(xPointer == 13) { //if end of column then go to next row and reset column pointer to 3 and increment shade pointer by 3
        yPointer++; //go down a row
        xPointer = 3;
        if((j % 3) == 0) {
            shadePtr = yPointer;
        }
    }
}