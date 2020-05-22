int[] res = new int[Integer.toString(num).length()];
do {
    remainder = num % 10;
    sum = sum + remainder;
    num = num / 10;
    res[count++] = remainder;  // LINE 1
} while (num > 0);

/*
Please enter an integer: 123456789

[9, 8, 7, 6, 5, 4, 3, 2, 1]
...