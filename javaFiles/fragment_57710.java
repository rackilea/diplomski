// pseudo code. You might want to use Calendar instead
accounts = realm.where(Account.class).findAllSorted("date")
Iterator<Account> it = accounts.iterator();
int previousMonth = it.next().getDate().getMonth();
while (it.hasNext) {
  int month = it.next().getDate().getMonth();
  if (month != previousMonth) {
    // month changed
  }
  previousMonth = month;
}