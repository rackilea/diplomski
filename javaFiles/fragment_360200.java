System.out.print("Please enter your first name: ");
String firstName = input.next();
System.out.print("Please enter your lastname: ");
String lastName = input.next();
System.out.print("Please enter your birthday day: ");
String birthdayDay = input.nextInt();
System.out.print("Please enter your birthday month: ");
String birthdayMonth = input.nextInt();
System.out.print("Please enter your birthday year: ");
String birthdayYear = input.nextInt();

TargetHeartRateCalculator patient = TargetHeartRateCalculator(firstName, lastName, 
birthdayDay, birthdayMonth, birthdayYear);