Scanner in = new Scanner(System.in);  // do this first, and give it a 
                                      // better name

System.out.print("Enter your name: ");  // use print to keep it on one line
String name = in.nextLine();  // read input, store it
System.out.print("Your name is: ");
System.out.println(name);  // print name