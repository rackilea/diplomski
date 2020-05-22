TransactionResult transactionResult;

try{
//do work and at the last line in the try after each operation that could 
have failed has been executed set your transactionResult variable
transactionResult = new SuccessTransaction();
}
catch(Excpetion e) { transactionResult=  new FailureTransaction();}
finally {Logger.logTransaction(transactionResult); }