Scanner scan = new Scanner(System.in);
int min = 0;
int max = 1000000;
double Amount = 0.0;
boolean isValid = false;

while (isValid == false) {
    if (scan.hasNextDouble()) {
        Amount = scan.nextDouble();
        if (Amount > max) {
            System.out.print("Error: You cannot enter a number greater than $1,000,000. Try again: ");
        }
        else if (Amount < min) {
            System.out.print("Error: You cannot enter a negative number. Try again: ");
        }
        else {
            isValid = true;
                }
        }
    else {
        System.out.print("Error: You must enter a number! Try again: ");
        scan.next();
    }
}