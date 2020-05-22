for (int i = 0;i < newBoard.length ;i++){
  for (int j = 0; j < newBoard[i].length;j++){
    int actualNumber = newBoard[i][j]; 
    for (int k = i; k < newBoard.length;k++){
    int l=0;
    if(k==i){
     l=j+1;
    }
    for (; l < newBoard[k].length; l++){ 
        if (actualNumber > newBoard[k][l]){ 
            // do stuff 
        }
      }
    } 
  } 
}