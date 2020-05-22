if(coins[i] > highestCoin){

        highestCoin = coins[i];

        if(i == 0){
            newCol = col; // this is important! do this for all cases!
            newRow = row - 1;

        }   
        ...     
    }