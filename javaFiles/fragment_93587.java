public int power(int x, int n){
    int k;
    if (n==2){
        k = square(x);
    }
    else if (n==3){
        k = cube(x);
    }
    else if (n==4){
        k = hypercube(x);
    }
    else if (n==1){
        k = x;
    }
    else {
        k = 1;
        for (int i = 0; i < n; i++) {
            k *= x;
        }
    }
    return k;
}