public static int generateNumber()
{
//Generates number and assigns it to the variable "randomNumber"
System.out.println("Generating random number between 0 and 100. Please wait.");
Random rand = new Random();
int randomNumber = rand.nextInt(101) + 1;
System.out.println("Random number generated");
return randomNumber;
}

public static void playGame(int randomNumber)
{
...
}

public static void main(String[] args)
{
//Declares methods to be used during process
int randomNumber = generateNumber();
playGame(randomNumber);
}