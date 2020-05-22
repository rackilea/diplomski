public static void main(String[] args) {
    Account account2 = new Account("B", true);
    Account account4 = new Account("D", false);
    Account account3 = new Account("C", true);
    Account account1 = new Account("A", false);

    List<Account> list = new ArrayList<>();
    list.add(account1);
    list.add(account2);
    list.add(account3);
    list.add(account4);

    Collections.sort(list, new AccountComparator());

    list.forEach(System.out::println);
}