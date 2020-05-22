public static void main(String[] args) throws Exception {
    int input;
    while ((input = InputHandler.getInt()) != 1 && input != 2) {
        if (input == InputHandler.CODE_ERROR)
            System.out.print("Input must be a number");
    }
}

public static class InputHandler {
    public static Scanner in = new Scanner(System.in);
    public static int CODE_ERROR = -6;

    public static int getInt(){
      try{
          return in.nextInt();
      } catch(InputMismatchException e){
          in.next();  // <------------------ this should solve it
          return CODE_ERROR;
      }
    }
  }