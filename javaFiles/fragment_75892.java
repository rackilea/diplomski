String bankCustomer = inputFile.nextLine();

//Assuming second line contains account number
String bankAccountNumber = inputFile.nextLine();

// Assuming third line contains account type.
String bankAccountType = inputFile.nextLine();

// Fourth line has your account balance
String bankAccountBalanceStr = inputFile.nextLine();

double bankAccountBalance = 0d;
if(null != bankAccountBalanceStr && 0 > bankAccountBalanceStr.length()){
     bankAccountBalance = Double.parseDouble(bankAccountBalanceStr);
}