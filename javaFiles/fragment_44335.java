/*
    *
    * The login params need to handle users with multiple accounts under the same username.
    *
    * Since Android's AccountManager does not allow multiple accounts per username, I had
    * to create a hack which joins and splits the username on a delimiter to serialize the
    * data and retrieve the account number for users with multiple accounts. I chose the @
    * sign as a delimiter because e-mail addresses have VERY few invalid characters in
    * the account name part of the address.
    *
    * If the user has multiple accounts, we need to create each one in AccountManager.
    *
    * */

    String[] accountParts = account.name.split("@");
    numParts = accountParts.length;
    if (numParts<2) {
        Log.wtf(Config.TAG, "Username split produced too few parts. WTF.");
        return null;
    }
    String email = accountParts[0] + "@" + accountParts[1];

    if (numParts==3) {
        String account_id = accountParts[2];
    } else if (numParts>3) {
        Log.wtf(Config.TAG, "Username split produced too many parts. WTF.");
        return null;
    }