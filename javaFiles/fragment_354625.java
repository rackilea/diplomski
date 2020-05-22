// I instantiate concrete classes but I refer interface as declared type.
BankAccount bankAcountDebitor = new ConcreteBankAccount();
BankAccount bankAcountCreditor = new ConcreteBankAccount();

// I invoke a method that takes as argument a type derived from the interface type 
bankAcountDebitor.transferBalance(bankAcountCreditor);