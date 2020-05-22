ArrayList<String> days = new ArrayList<String>(); 
ArrayList<Double> temp = new ArrayList<Double>(); 

days.add("Monday");
days.add("Tuesday");
days.add("Wednesday");
days.add("Thursday");
days.add("Friday");
days.add("Saturday");
days.add("Sunday");

Scanner scnr = new Scanner(System.in);

System.out.println("Please enter the temperature for Monday through 
  Sunday below.\n" );

for (int i = 0;i < 7; i++) { // Loop 7 times for each day of the week
   System.out.print("Enter day of week: ");
   days.add(scnr.next());
   System.out.print("Enter temperature: ");
   temp.add(scnr.nextDouble());
}

// You ask for user input here
System.out.print("Enter 'week' here to see temperature details: ");
String userChoice = scnr.next();

while ("week".equalsIgnoreCase(userChoice)) {

  System.out.println("-----------------------------");
  System.out.println("Day\t" + "\tTemperature");
  System.out.println("-----------------------------");

  for(int i = 0; i < 7; i++) {

     System.out.println(days.get(i));
     System.out.print("\t" + "\t");
     System.out.println(temp.get(i));

  }
  double sum = 0.0;

  for ( int i = 0; i < temp.size(); i++) {
      sum += temp.get(i);
  }
  double average = (double) sum / temp.size();
  System.out.println("\n" + "Average temperature = " + average);

  //Ask user if he'd like to see the information again.
  System.out.print("Enter 'week' here to see temperature details again: ");
  userChoice = scnr.next();
}