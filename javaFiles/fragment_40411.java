for (int i = 2; i < Math.sqrt(n); i++){
    if (n % i == 0){
        System.out.print(n/i);
        break;
    }
}