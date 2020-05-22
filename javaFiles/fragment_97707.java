public static int Sigma(int s){
    int a = 0;
    for(int i=1;i<=s;i++){
        if(s%i==0)
            a = a + i;

    }
    System.out.print(a); //why do you have it here?
    return a;

}