public static int getRow(int number) {
    int result=0;
    int sum=0;  
    while(sum<number) {
        result++;
        sum+=result;
    }
    return result;
}