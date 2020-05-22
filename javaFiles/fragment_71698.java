int i = 0
while(i < 10) {
    odd = keyboard.nextInt();
    if (odd % 2 != 0) {
        sum = sum + odd;
        i++;
    }
}
System.out.println("The sum of first 10 odd numbers is " + sum);