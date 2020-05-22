Account account = new Account();
Contact contact = new Contact();

account.addToContact(contact);
em.persist(account);
em.flush();

assertNotNull(account.getId());
assertNotNull(account.getContacts().get(0).getId());
assertEquals(1, account.getContacts().size());

account.removeFromContact(contact);
em.merge(account);
em.flush();
assertEquals(0, account.getContacts().size());