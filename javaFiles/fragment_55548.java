int x = 0;
boolean isAgeReached = false;

while (!isAgeReached) {
    if (x < 21) {
      System.out.println("You cannot drink because you are only " + x + " years old.");
      x++;

    } 
     else {
       System.out.println("You may drink because you are " + x + " years old.");
       isAgeReached = true;
    }
}