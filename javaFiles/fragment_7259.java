public int recurvMath(int n){    
    System.out.println("N:" +n);
    if(n == 0){
        return 0; 
    } else {
        return recurvMath(n-1) + (n * n);
    }
}