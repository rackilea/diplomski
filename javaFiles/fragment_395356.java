for(int i=0; i < DefensiveOppsArray.length; i++){
    for(int j=0; j < DefensiveOppsArray.length; j++){
        //path for straight down
        for(j=0; j < DefensiveOppsArray.length; j++){ // << here you use j again as counter
            path[j] = TicTacToeArray[i][j];
            DefensiveOppsArray[i][j]=DefensiveOppsArray[i][j] + 1;
        }
     }
}