int tabuListEntry = tabuList[i][j];
int decrementAmount = 0; 
if(tabuListEntry  > 0) {
    decrementAmount = 1;
}
tabuListEntry = tabuListEntry - decrementAmount ;