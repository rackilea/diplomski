} else if (key == 'R' || key == 'r') { 
    //initialize h string to null
    if (h != null) {
      h = null;  
    }

    String numberString = "74,34...";
    String[] numbers = splitTokens(numberString, ",");

    int index = int(random(numbers.length));
    randomnumber = numbers[index];

  } else if (key == 'H' || key == 'h') { 
    //initialize random number to null
    if (randomnumber != null) {
      randomnumber = null;  
    }

    h = "hello there";
  }