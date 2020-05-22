public int modulo(int a, int b){
    if(a < 0){
        return (a + b) % b;
    }
    return a % b;
}