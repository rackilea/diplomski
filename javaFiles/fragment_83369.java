@Transactional
public void transfer(Account a, Account b, int amount) {
    a.reduce(amount);
    b.add(amount),
    accountRepository.save(a);
    accountRepository.save(b);
}