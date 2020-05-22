while(true)
{
    customerID[i] = myScanner.nextLine();
    if(customerID[i].length() == 5) break;
    System.out.print("Should be of length 5! Try Again: ");
}