session = sessionFactory.openSession();
session.beginTransaction();

List<Book> bookList = session.createQuery("from Book").list();

for (Book book : bookList) {
    for (Name address: book.getNameList());
    for (Description description: book.getDescriptionList());
}

session.getTransaction().commit();
session.close();