private int firstUnusedId(List<Account> accounts) {
    List<Integer> ids = new ArrayList<>();
    // Foreach loop.
    for(Account account: accounts) {
        ids.add(account.getAcc());
    }
    Collections.sort(ids);
    for (int index = 0; index < ids.size(); ++index) {
        if (ids.get(index) != index + 1) {
            return index + 1;
        }
    }
    return ids.size() + 1;
}