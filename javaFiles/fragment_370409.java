Scanner in = new Scanner(System.in);
int number, valuesIn;
double average = 0;

do {
    number = in.nextInt();
    if(number > 0 && number != 99999) {
        valuesIn++;
        average += number;
    }
} while(number != 99999)

average /= valuesIn;