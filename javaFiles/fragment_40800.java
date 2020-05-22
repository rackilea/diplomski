int min = Integer.MAX_VALUE;
int max = Integer.MIN_VALUE;

int num = input.nextInt();

while (num % 2 != 0) {
    sum += num;

    if (num < min) {
        min = num;                
    }
    if (num > max) {
         max = num;
    }

    num = input.nextInt();
}

System.out.print("Minimum Odd Number: " + min + ";");
System.out.println("Maximum Odd Number: " + max);
System.out.print("Sum: " + sum);