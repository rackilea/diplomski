Client client = new Client();
        entityManager.persist(client);
        Contact contact = new Contact();
        entityManager.persist(contact);
        client.getContacts.add(contact);
        entityManager.merge(client);

        Contact contact2 =entityManager.find(Contact.class,contact.getId());
        //and now Unique index or primary key violation will appear 
       //because you are using the default equals and hashcode implementation  
       //adding contact2 will not replace the old one
        client.getClients().add(client2);
       entityManager.merge(client);//Unique index or primary key violation