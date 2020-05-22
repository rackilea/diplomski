int first = 0, second = 0;
     for(i = 0; i<score.length-1; i++){     //first find and store the highest values
        if(score[i]> score[i+1]){
            if(score[i]>first){
                second = first;   // *NEW* the former first place is now the second !
                first = score[i]; //first = 541 //NAN // NAN
            }
            if(score[i+1]>second){ //second = 538 //NAN // NAN
                second = score[i+1];
            }
        } else {
            if(score[i+1]>first){
                second = first;
                first = score[i+1];//NAN // 522< 541 // first = 6000
            }
            if(score[i]>second){
                second = score[i];//NAN // NAN // NAN
            }
        }   
    }