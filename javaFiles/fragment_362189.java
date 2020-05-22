Scanner input = new Scanner(System.in);
    int loop = input.nextInt();

    String numberString[]=new String[loop]; //remove last block of array. +1 is useless

    for(int i=0; i<=loop; i++){
        String ans = input.nextLine();
        numberString[i] = ans;
    }
    sum2(numberString);

}