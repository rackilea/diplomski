String answer;
boolean yn;

System.out.println("y/n");
while (true) {
  answer = in.nextLine().trim().toLowerCase();
  if (answer.equals("y")) {
    yn = true;
    break;
  } else if (answer.equals("n")) {
    yn = false;
    break;
  } else {
     System.out.println("Sorry, I didn't catch that. Please answer y/n");
  }
}