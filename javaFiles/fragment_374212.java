Scanner scan = new Scanner(System.in); //Initializes scanner

  int num=0;  //Creates array for input numbers
  int sum=0;
  String restart ="y";
  List<Integer> numbers = new ArrayList<Integer>(); //Creates array list for input

  while (restart.equals("y")) {
     System.out.print("Please input integers, note that -1 ends the submissions: "); //Prompts the user for input

     num=0;
     sum=0;         
     numbers.clear();

     for(; ;)
     {
        num = scan.nextInt(); //Continues to read numbers and add them to the sum
        if (num == -1){
           break;
        }
        numbers.add(Integer.valueOf(num)); //Adds the values to the value of num to the array list
        sum += num; //Calculates the sum
        continue;  
     }
     System.out.print("The numbers entered are:    " + numbers); //Prints the numbers and the sum
     System.out.print("\nThe sum of the numbers is:  " + sum + "\n");
     System.out.print("Would you like to restart? Y or N: ");
     restart = scan.next();  
  }

  System.out.print("The program has ended!");