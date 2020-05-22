private static void testWriting(Session session) {
        session.beginTransaction();

        Bookshelf b2 = new Bookshelf();
        session.save(b2);

        Book b = new Book();
        b2.addBook(b);

        session.save(b);
        session.getTransaction().commit();
    }
}