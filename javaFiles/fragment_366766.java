class AccountsModel {
    private static ArrayList<AccountModel> singleton;

    // a static constructor also wouldn't be a bad idea here
    public static void init() {
        /* add a bunch of AccountModels here*/
    }

    public static ArrayList<AccountModel> getAccounts() {
        return singleton;
    }
}