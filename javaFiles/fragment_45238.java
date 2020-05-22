Scanner console = new Scanner(System.in);

int maxNumbers = 0;
int totalSum = 0; // Sum of all numbers (positive and negative)
int totalAverage = 0; // Average of all numbers (positive and negative)
int positiveSum = 0; // Sum of all positive numbers
int positiveAverage = 0; // Average of all positive numbers
int positiveNumberCount = 0; // Amount of positive numbers entered

System.out.print("Enter Max Numbers: ");
maxNumbers = console.nextInt();
System.out.println();

for(int i=1; i<=maxNumbers; i=i+1)
{
    System.out.print("Enter Value " + i + ": ");
    int num = console.nextInt();

    if(num >= 0) {
      positiveSum = positiveSum + num;
      positiveNumberCount = positiveNumberCount + 1;
    }

    totalSum = totalSum + num;
}

positiveAverage = positiveSum / positiveNumberCount;
totalAverage = totalSum / maxNumbers;