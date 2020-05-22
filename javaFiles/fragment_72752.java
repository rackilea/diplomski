for (i = 0; i < employees.length i ++){
  if(!inputFile.hasNextLine()){
      break;
  }
  String dummyNumber = inputFile.nextLine();
  int theNumber = Integer.parseInt(dummyNumber);
  String theName = inputFile.nextLine();
  String theDepartment = inputFile.nextLine();
  String thePosition = inputFile.nextLine();
  String dummySalary = inputFile.nextLine();
  double theSalary = Double.parseDouble(dummySalary);
  String dummyRank = inputFile.nextLine();
  int theRank = Integer.parseInt(dummyRank);


  employees[index] = new ScottEmployee2(theNumber, theName, theDepartment, thePosition, theSalary, theRank);
  index++;
}