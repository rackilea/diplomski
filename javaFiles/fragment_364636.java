int sum;
while(guess != 0)
{   
    guess = keyboard.nextInt();
    sum += guess;
}
System.out.println("Total: " + sum");