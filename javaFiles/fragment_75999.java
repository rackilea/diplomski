static int test(){
    int x = 1;
    try{
        return x;
    }
    finally{
        x = x + 1;
        System.out.println(x);  // Prints new value of x
    }
}