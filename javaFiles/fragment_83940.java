Group group = new Group();

// Notice as shown bellow accountNumber is null
Account account = new Account();
account.setId(1);

group.addAccount(account);

entityManager.persist(group);