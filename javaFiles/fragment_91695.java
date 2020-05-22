int smallestNumb = Integer.MAX_VALUE, choice;
Scanner numbIn = new Scanner(System.in);

for(i = 0 ; i < 5 ; i++){
    System.out.println("Enter a number");
    choice = numbIn.nextInt();
    if(smallestNumb > choice) {
        smallestNumb = choice;
    }
}

System.out.println(smallestNumb);