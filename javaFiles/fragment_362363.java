if(map[i][j] == 1){
            while(spot<4){ // <<<< you increase spot until it equals 4
                map[i][j] = 5;
                spot++;
            }
        }