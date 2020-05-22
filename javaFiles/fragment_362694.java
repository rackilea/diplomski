int k=0;
while(input.hasNext()) {
  if(input.hasNextInt()) {
    sum += input.nextInt();
  } else {
    System.err.println("What ? It's not an integer...");
    if ( k < 1 ) {
      System.err.println("I'm gonna try again !");
      k++;
    } else {
      System.err.println("'"+input.next()+"' it's definitively not an integer");
      k=0;
    }
  }
}