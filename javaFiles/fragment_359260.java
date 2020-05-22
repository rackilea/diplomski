for (i = 0; i < numpc - 1; i++){
    if (i == 0 && score[i + 1] > score[i]){
        first = i + 1;
        second = i;
    }
    if(i == 0 && score[i + 1] < score[i]){  //<--- you had > here
        first = i;
        second = i+1;
    }
    if (score[i + 1] > score[i]){
        second = first;
        first = i+1;
    }
    if (score[i] > score[i+1]){
        second = first;
        first = i;
    }
}