String numbers = "";
num = 123;
digit = num % 10; // digit=3
num /= 10; // num=12
numbers = digit + " " + numbers; // numbers="3 " uses old value on right side of the equals

// next iteration
digit = num % 10; // digit=2
num /= 10; // num=1
numbers = digit + " " + numbers; // numbers="2 3 " see how the digit is put to the left of the old value

// last iteration
digit = num % 10; // digit=1
num /= 10; // num=0
numbers = digit + " " +numbers; // numbers="1 2 3 " notice there is an extra space at the end which is ok for your example