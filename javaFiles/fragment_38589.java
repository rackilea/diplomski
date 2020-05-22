System.out.println("Enter something > ");
    Scanner input = new Scanner(System.in);

    //read in string entered by user
    String inputString = input.nextLine();

    //split the string into an array of strings, using [space]
    String[] split = inputString.split(" ");

    //create a new int array, and populate it with the contents of the split string
    int intarray[] = new int[split.length];

    for (int i = 0; i < split.length; i++) {
        intarray[i] = Integer.parseInt(split[i]);
    }