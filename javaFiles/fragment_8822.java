Scanner in = new Scanner(System.in);
int[] numbersList = new int[10];
int amount = 0;
int total = 0;

do { //stop at negative
    int number = in.nextInt();
    if (number < 0) {
        // if a negative number is entered then stop looping
        break;
    }

    amount += 1;

    // use modulo arithmetic to assign numbers, the accessed index will
    // range from 0 to 9
    numbersList[amount % 10] = number;

    // iterate over numbersList and sum entries
    for(int i = 0; i < numbersList.length; i++){
        total += numbersList[i];
    }

    // output total
    System.out.println(total);

    // reset total to 0
    total = 0;
} while(number >= 0); // this is redundant since we check earlier

System.out.println(total);