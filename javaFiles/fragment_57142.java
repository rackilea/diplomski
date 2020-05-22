Scanner inputFile = new Scanner(hotlist);
while (inputFile.hasNext()) {
    customerName[i] = inputFile.nextLine();
    System.out.println(customerName[i]);
    String custId = inputFile.nextLine();
    customerID[i] = Integer.parseInt(custId);
    os[i] = inputFile.nextLine();
    typeOfProblem[i] = inputFile.nextLine();
    String turnAround = inputFile.nextLine();
    turnAroundTime[i] = Integer.parseInt(turnAround);
    i++;
}