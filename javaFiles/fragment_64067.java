class Account {
    String id;
    String name;
    float balance;
    List<Transaction> history;
}

class Transaction {
    String id;
    Date date;
    double amount;
}