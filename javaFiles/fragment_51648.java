String numbers = "";
while (num > 0) {
    temp = num;
    sum = sum + num % 10;           //Extracts the last digit and adds it to the sum
    num = num / 10;                 //removes the last digit
    // System.out.print(temp % 10 + " ");
    numbers = (temp % 10) + " " + numbers;
}

System.out.println(numbers + "and the sum is " + sum);