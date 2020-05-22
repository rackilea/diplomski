public static void message(int n){
    if (n > 0){
        {
            System.out.println("This is a recursive method");
            message(n-1);
        }
    }
    return;
}