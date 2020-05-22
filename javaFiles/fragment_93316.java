int count = 0;
for (int i=0; i<5; i++) {
   if (secretNumber[i] == guess[i])
       count++;
}

if (count >= 3)
    System.out.print("You guessed " + count + " numbers correct, therefore you win");
else
    System.out.print("You only guessed " + count + " number(s) correct, therefore you lose");