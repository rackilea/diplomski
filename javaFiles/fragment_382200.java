/*
All four digits are different
The digit in the thousands place is three times the digit in the tens place
The number is odd
The sum of the digits is 27
*/

// Start at 4 digit numbers, only iterate odd numbers
for (int i = 1001; i <= 9999; i += 2) {

    // break the four digits into seperate variables
    int num4 = i % 10;
    int num3 = i / 10 % 10;
    int num2 = i / 100 % 10;
    int num1 = i / 1000 % 10;

    // check that the "first" number is 3x the "third"
    if (num1 != (num3 * 3))
        continue;

    // make sure all numbers are unique
    if (num1 != num2 && num1 != num3 && num1 != num4 && num2 != num3 && num2 != num4 && num3 != num4)
        // and they sum to 27
        if ((num1 + num2 + num3 + num4) == 27)
            System.out.println(i);
}