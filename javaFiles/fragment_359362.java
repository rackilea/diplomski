public static void main(String[] args) {
    // TODO code application logic here
    Scanner in = new Scanner(System.in);
    int a = 0;
    int n = in.nextInt();
    int orign = n;
    while(n >0){
        int temp = n %10;
        a = a*10+temp;
        n = n/10;
    }
    System.out.println(a);
    if( orign == a){
        System.out.println("The number is palindrome");
    }else{
        System.out.println("The number is not palindrome");
    }
}