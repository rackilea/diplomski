int twoDm[][]= new int[5][7];
int i,j,k=1;
int skipped = 0;
outer:
for(i=0;i<5;i++) {
    for(j=0;j<7;j++) {
        if (skipped < startofmonthtext) {
            skipped ++;
            continue;
        }
        twoDm[i][j]=k;
        k++;
        if (k > daystext) break outer;
    }
}