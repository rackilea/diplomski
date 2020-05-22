int tabuListEntry = tabuList[i][j];
int decrementAmount = 0; 
if(tabuListEntry  <= 0) {
    decrementAmount = 0;
} else {
    decrementAmount = 1;
}
tabuListEntry = tabuListEntry - decrementAmount ;