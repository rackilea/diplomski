int [][] num = {{1,4,3,0,5},{2,4,7,8,10},{3,9,60,20,4}};
int row, col;
for (row=0;row<3;row++){
colcount = 0; //count if is the first column
mincol = 0;
maxcol = 0;
for (col=0;col<5;col++){    

    if(colcount == 0){ //if first time at the loop
        mincol = num[row][col]; //mincol will be the first column
        maxcol = num[row][col]; //maxcol will be the first column
        colcount++;
    }else{
        mincol = (mincol < num[row][col]) ? mincol : num[row][col]); //will verify if the mincol is really the lowest. If true, will maintain the mincol value.. else .. will get the current column.
        maxcol = (maxcol > num[row][col]) ? maxcol : num[row][col]); //same of mincol, but using maxcol.
    }
}