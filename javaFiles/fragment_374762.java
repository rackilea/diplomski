public void askForNumbers() {

    Scanner in = new Scanner(System.in);
    // use the sout before the system.in waits for you first input
    System.out.println("Please enter 5 nums from 1 to 50.");
    numbers = in.nextLine();
    String[] playersNumbers = (numbers.split(" "));
    int[] intPlayersNumbers = new int[playersNumbers.length];
    // check if the array has lenght 5 directly after the split.
    if (intPlayersNumbers.length != 5) { // if the split.length != 5 start over
      askForNumbers();
    }
    else {
      for (int a = 0; a < playersNumbers.length; a++) {
        int i = Integer.parseInt(playersNumbers[a]); //beware this can cause a numberFormatException !!!
        if (i > 0 && i < 51) {  // if one of the number is not in range start over. 
          intPlayersNumbers[a] = i;
        }
        else {
          System.out.printf("%d was not between 0 and 50", i); // print which integer was the culprit
          askForNumbers();
          return; //return so this method ends here; 
          }
      }
      raffleArray = intPlayersNumbers; // or return intPlayersNumbers , you will have to change the return type of the method as well
    }
  }