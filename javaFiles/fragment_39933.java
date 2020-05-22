AccountManager accountManager = AccountManager.get(this); //this is Activity
    Account account = new Account("MyAccount","com.company.demo.account.DEMOACCOUNT");
    boolean success = accountManager.addAccountExplicitly(account,"password",null);
    if(success){
        Log.d(TAG,"Account created");
    }else{
        Log.d(TAG,"Account creation failed. Look at previous logs to investigate");
    }