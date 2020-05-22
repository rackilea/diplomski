public void printOneToN(int n) {
    if(n > 1) {
        printOneToN(n - 1);
    }
    System.out.println(n);
}