do {
    remainder = num % 10;
    sum = sum + remainder;
    num = num / 10;
    count++;
    System.out.println(remainder);
} while (num > 0);

/*
Please enter an integer: 123456789

9
8
7
6
5
...