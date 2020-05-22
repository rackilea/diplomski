public static void main(String[] args) {

    //int result;
    int col = 0;
    Scanner input=new Scanner(System.in);
    n=input.nextInt();
    if(n < 4)
        System.out.println("the result is 0");
    else {
        NQueens nq = new NQueens();
        nq.count(n);
    }

}