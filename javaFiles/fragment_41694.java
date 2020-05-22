System.out.println("Enter your number of shoes: ");
Scanner in = new Scanner(System.in);

int numberOfShoes = 0;
int sum = 0;
int numberOfInputs = 0;

do {
    numberOfShoes = in.nextInt();

    if (numberOfShoes >= 1 && numberOfShoes <= 200) { // if valid input
        sum += numberOfShoes;
        numberOfInputs++;
    }

} while (numberOfShoes >= 1 && numberOfShoes <= 200); // continue while valid

double average = (double)sum / numberOfInputs;

System.out.println("Average: " + average);