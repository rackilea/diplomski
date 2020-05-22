public void saveContact(Contact contact) {

    Session session = sessionFactory.getCurrentSession();

    if (contact.getContactId() == 0 || contact.getContactId() == null) {

        session.save(contact);
        session.flush();

    }

}