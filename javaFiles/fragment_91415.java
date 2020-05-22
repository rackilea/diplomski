public static void main(String[] args) {
    while(true){
        process();
    }
}

static void process(){
    System.out.println("Please enter your official name.");

    Scanner typing = new Scanner(System.in);
    String name = typing.nextLine();

    while (!name.matches("[a-zA-Z]")) {
      System.out.println("Please enter your official name.");
      name = typing.nextLine();
    }
    if (name.length() >= 4)
      System.out.println("Your name is: " + name);

    else
      System.out.println("So your name is less than four characters.");
}