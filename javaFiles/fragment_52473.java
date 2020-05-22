boolean understood;
do {
    understood = false;

    String a = input.nextLine();
    int num = Integer.parseInt(a);

    switch (num) {
        case 1:
               System.out.println("hello");
               understood = true;
               break;
         case 2:
               System.out.println("goodbye");
               understood = true;
               break;
         default:
               System.out.println("i dont understand u");
               break;
    }
} while (!understood);