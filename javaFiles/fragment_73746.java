while (true) {
  int balance = account.getBalance();
  if (balance >= amt) {
    // Other stuff.
    if (account.withdrawIfBalanceEquals(balance, amt)) {
      // If true, we don't have to keep looping: we withdrew the
      // balance.
      break;
    }

    // If false, keep going: you'll read the balance again,
    // check if it's still greater than balance etc.

  } else {
    System.out.println("Not enough balance");
    break;
  }
}