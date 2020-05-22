public int getSum(int lower, int upper){
    int sum = 0;
    for(int i=lower;i<=upper; i++){
        sum += i;
        System.out.println("the total sum is "+ sum);
    }
    return sum;
}