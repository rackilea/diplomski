public int modulo(int a, int b){
    if(a < 0){
        return (a % b + (1 + (Math.abs(a) / b)) * b) % b;
    }
    return a % b;
}