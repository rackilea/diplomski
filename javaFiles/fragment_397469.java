public void recursiveMe(int n) {
    if(n <= 10) {// 10 is the max limit
        System.out.println(n);//print n
        recursiveMe(n+1);//call recursiveMe with n=n+1
    }
}
recursiveMe(1); // call the function with 1.