SessionFactory sessionFactory = configuration.buildSessionFactory();

Session session = sessionFactory.openSession();
session.beginTransaction();

// Ten books
for (int i = 0; i < 10; i++) {
    Book book = new Book();
    book.setName(RandomStringUtils.random(13, true, false));

    // For each book, Ten names and descriptions
    for (int j = 0; j < 10; j++) {
        Name name = new Name();
        name.setSomething(RandomStringUtils.random(13, true, false));

        Description description = new Description();
        description.setSomething(RandomStringUtils.random(13, true, false));

        book.getNameList().add(name);
        book.getDescriptionList().add(description);
    }

    session.save(book);
}

session.getTransaction().commit();
session.close();