int yPointer = 7;
int xPointer = 3;
boolean shade = false;

for (int j = 0; j <= 299; j++) {
    ...
    if(xPointer == 13) { // end of column
        yPointer++; //go down a row
        xPointer = 3;
        shade = (j % 3) == 0;
    }
}