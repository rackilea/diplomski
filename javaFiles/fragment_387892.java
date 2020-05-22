public void compute(int num){
    for (i = 2; i <= num / 2; i++) {
    if (num % i == 0) {
        System.out.print(i + " , ");
        }
    }