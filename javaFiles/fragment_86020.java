public int acker(int m, int n){
    System.out.println("Entered acker");
    int result;
    if(m == 0)
        result = n + 1;
    else if(n == 0)
        result = acker(m-1,1);
    else
        result = acker(m-1, acker(m, n - 1));
    System.out.println( "Returning " + result + " from acker");
    return result; 
}