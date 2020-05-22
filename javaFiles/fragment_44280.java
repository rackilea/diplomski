if(i>0){
    // Try something like this instead
    if((staticWallLoc[i-1][j]&4)>0){
      staticWallLoc[i][j]=staticWallLoc[i][j]|1;
    }
}