System.out.println("\nItems selected : ");
int tempW = W;
int y = 0; //to index in selected
for (int x = n; x > 0; x--){
    if ((tempW-wt[x-1] >= 0) && (K[x][tempW] - K[x-1][tempW-wt[x-1]] == val[x-1]) ){
        selected[y++] = x-1; //store current index and increment y
        tempW-=wt[x-1];
    }
 }
 for(int j = y-1; j >= 0; j--){
    System.out.print("#" + (selected[j]+1) + " ");
    System.out.println(val[selected[j]]);
}