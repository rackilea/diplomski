public void withd(double amount)                                      
  {
      if (amount > balance) {
        System.out.println("Error");
      } else {
        balance = balance - amount;  
      }
  }