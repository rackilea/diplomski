SavingsAccount sa = i.next();
  if (sa.getId().equals(rmvID)) { // just an example.. I don't know how you access the 
                                  // saving account's id nor it's type. This example expect
                                  // it is `Integer`
     i.remove();
  }