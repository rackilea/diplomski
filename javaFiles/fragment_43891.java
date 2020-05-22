public void monthlyFee(double fee) { //monthly fee for bank accounts
    for(int i = 0; i < bank.length; i++) {
      if(bank[i] != null) {
        System.out.println(bank[i].adjust(fee));
      } //I have tried BankAccount.adjust() and couldn't work, bank[i].adjust() nothing seems to work
    }
  }