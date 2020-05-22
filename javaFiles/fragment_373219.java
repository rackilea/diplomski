for(int i=1; i < 100; i++){
    boolean isPrime = true;

    //check to see if the number is prime
    for(int j=2; j < i ; j++){
        if(i % j == 0){
            isPrime = false;
        }
    }

    // print the number
    if(isPrime)
        System.out.print(i + " ");
}