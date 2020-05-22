Map<String, Set<Bank>> result = new HashMap<>();
for (Bank bank : banks) {
    for (String branch : bank.getBranches()) {
        result.computeIfAbsent(branch, b -> new HashSet<Bank>()).add(bank);
    }
}