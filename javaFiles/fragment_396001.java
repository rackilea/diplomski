Account[] accounts = new Account[] {
    new Account("Account1", "1", "2", "3", "4", "5"),
    // the rest of the accounts
};

AccountRepository repository = new AccountRepository(Arrays.asList(accounts));
Customers customers = new Customers(repository);
Staff staff = new Staff(repository);