for (int i = 0; i < 10; i++) {
    acct[i] = new Account(); // add this line to crate account
                             // and place it in array
    acct[i].set_account_id(i + 1); // also you are getting error here
    acct[i].set_account_balance(100); // not here because you ware trying to 
                                      // invoke method on `null`
}