public class AccountComparator implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        if (o1.isActive() && !o2.isActive()) {
             return -1;
        }
        if (!o1.isActive() && o2.isActive()) {
            return 1;
        }
        return o1.getName().compareTo(o2.getName());
    }
}