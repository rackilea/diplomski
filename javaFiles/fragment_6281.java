String[] Company = {"Honda", "Toyota", "Ford", "Chevrolet", "Lexus", "Jeep"}// add whatever companies you want here
Random rand = new Random();
int NumberOfAnswers = Company.length;
int pick = rand.nextInt(NumberOfAnswers);
String CompanyChoice = Company[pick];
System.out.println("The company of your car is " + CompanyChoice);