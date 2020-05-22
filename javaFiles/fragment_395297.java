public Account getAccountById(int accountId, Set<String> fetchPolicy) {
    Account account = accountRepository.findOne(accountId);
    if(fetchPolicy.contains("contacts")){
        account.setContacts(contactRepository.findByAccountId(account.getAccountId());
    }
    return account;
}