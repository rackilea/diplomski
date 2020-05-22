int maxPalindrom(String x){
    int max = 0;
    int current;
    for(int i=0; i<x.length - 1; i++){
        current = 1;
        for(int j = 1; j < min(x.length - i, i); j ++){
            if(x[i-j] == x[i+j])
                current += 2;
            else
                break;
        }
        if (current > max) current = max;
        current = 0;
        for(int j = 0; j < min(x.length - i, i); j ++){
            if(x[i - j] == x[i + 1 - j])
                current += 2;
            else
                break;
        }
        if (current > max) current = max;
    }
    return max;
}