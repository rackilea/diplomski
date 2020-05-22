Query query = em.createQuery(
   "Select b FROM Book b JOIN b.student s " +
   "WHERE s.name = :studentname AND b.followUpNumber = :follownbr"
);
query.setParameter("studentname", "Student name 6");
query.setParameter("follownbr", Long.valueOf(4));
Book book = (Book)query.getSingleResult();

System.out.println("Found book = " + book.getTitle());
System.out.println("book follow nbr= " + book.getFollowUpNumber());