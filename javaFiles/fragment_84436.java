final Map<Person, Set<Account>> accountsByPerson = new HashMap<>();

// add account acc1 for a person per1
Set<Account> accountsForThisPerson = accountsByPerson.get(per1);
if (accountsForThisPerson == null) {
    accountsForThisPerson = new HashSet<>();
    accountsByPerson.put(per1, accountsForThisPerson);
}
accountsForThisPerson.add(acc1);

// retrieve one person's accounts:
final Set<Account> accountsOfPerson1 = accountsByPerson.get(per1);
if (per1 == null) {
    System.out.println(per1 + " has no accounts");
}
else {
    System.out.println(per1 + " has " + accountsOfPerson1.size() + " account(s)");
    for (final Account a : accountsOfPerson1) {
        System.out.println(perl + " has account " + a);
    }
}