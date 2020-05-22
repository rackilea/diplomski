Scanner in = new Scanner(System.in);
     int a,b,n,t;
     String input_line;
     String[] input_numbers = new String[3];

    t = in.nextInt();
    in.nextLine();
    input_line = in.nextLine();

    while(!input_line.equals("")){
          input_numbers = input_line.split(" ");
          // do what you want with numbers here for instance parse to make each string variable into int or create new scanner to do so
          input_line = in.nextLine();
    }
}