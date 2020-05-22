public Optional<Account> getGreenqloudAccount(String accountUUid) {
    System.out.println("tmplog: GreenqloudAccountDao->getGreenqloudAccount");
    return apiClient.accountList().stream()
            .filter(account -> account.getUuId().equals(accountUUid))
            // you can 'peek' and log 
            .findFirst(); // you return the first account or empty 
}