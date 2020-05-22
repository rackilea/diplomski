while (guess != a) {
    guess = keyboard.nextInt();
     count++;
    if (guess < 0 || guess > 100){
        if(guess == -1)
             break;
        System.out.println("Out of bounds");
        continue;
    }
    if (guess > a) {
        System.out.print("The number is lower. Try again: ");
    } 
    else if (guess < a) {
        System.out.print("The number is higher. Try again: ");
    }
    else if (guess == a) {
    System.out.println("Congratulations. You guessed the number in "
    + count + " tries!");
 }
 System.out.println("Thank-you for playing the game!!");