class Account {
  String name;
  int number;
  float money;

  Account(String name, int number, float money) {
    this.name = name;
    this.number = number;
    this.money = money;
  }

}

// And somewhere else you'll want to use that class : 
List<Account> accounts = new ArrayList<>();
account.add(new Account("Account1", 1, 1f));
account.add(new Account("Account2", 2, 2f));
account.add(new Account("Account3", 3, 3f));