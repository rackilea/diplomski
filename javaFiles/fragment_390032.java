if(!isSatisfied(tissue,i,j,threshold)){
                    temp = tissue[i][j];
                    outer:
                    for(int k=0; k<tissue.length; k++){
                        for(int l=0; l<tissue.length; l++){
                            if(tissue[k][l] == ' '){
                                tissue[i][j] = arr[k][l];
                                arr[k][l] = temp;
                                break outer;
                            }
                        }
                    }
                }