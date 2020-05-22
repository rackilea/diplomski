public Account(/*you dont need a parameter*/){
   this.id = setIdByScannedValue();
   this.balance = setBalanceByScannedValue();
   //this.interestRate = setInterestRateByScannedValue();
}

private void setIdByScannedValue(){
    Scanner sc = new Scanner(System.in);
    boolean provided = false;
    while(!provided)
    try{
        System.out.print("provide id: ");
        this.id = sc.nextInt();
    }catch(NumberFormatException e){
        System.out.println("you must provide an integer id format !!!");
    }finally{
        provided = true;
    }
}