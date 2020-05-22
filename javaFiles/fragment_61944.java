if(!visible[x+i][y+j]){
  visible[x+i][y+j] = true;
  if(num[x+i][y+j] == 0) {
    fillNeighbours(x+i, y+j);
  }
}