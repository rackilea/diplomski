insertScore(int[] scores, int mscore){
        //find insert point
        int i = 0;
        while(i < scores.length && scores[i] > mscore){
            i++;
        }
        if(i < scores.length){
            //you found a place to insert the score
            for(int j = scores.length-1; j > i; j--){
                scores[j] = scores[j - 1];
            }
            scores[i] = mscore;
        }
   }