public boolean checkSuper(int num) {
    int n1;
    int n2 = num;
    while(num > 0) {
        if(num % 10 == 0) {
            return false;
        }
        n1 = num % 10;
        if(n2 % n1 == 0) {
            num = num / 10;
        } else {
            return false;
        }
    }
    return true;
}