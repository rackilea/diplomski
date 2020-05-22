VendingMachine vendingMachine = new VendingMachine();
try {
    //vendingMachine.checkInput() is not available because it is private
    vendingMachine.doSomething(); // public method is available
} catch (Exception e){
    // validation failed and threw an Exception
}