public static void main(String[] args){
    int num = 12345;
    System.out.println(num);
    for(int i = 0; i < 4; i++) {
        int first = num / 10000;
        int last4 = num % 10000;
        num = last4 * 10 + first;
        System.out.println(num);
    }
}