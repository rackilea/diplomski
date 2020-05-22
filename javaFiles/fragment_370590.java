for(int i = 1; i < size - 1; i++){
    for(int j = 1; j <= i; j++){
        if(series[i] == series[i - j]){
            series[i + 1] = j;
            break;
        }else{
            series[i + 1] = 0;
        }
    }
}