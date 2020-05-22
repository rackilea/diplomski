int increment= 2;

for(int n = 0; n < 9; n++){
    for(int i = increment*2; i < a.length; i += increment){
        a[i] = false;
    }
    increment += 1;
}