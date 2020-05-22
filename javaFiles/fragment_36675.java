for(int i=1; i<=10; i++){
    int factors = 0;
    int j=1;

    while(j<=i){
        if(i % j == 0){
            factors++;
        }
        j++;
    }
    if(factors==2){
        System.out.println(i);
    }
}