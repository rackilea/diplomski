@Formula("(SELECT COUNT(bc.id) FROM book b " +
         "left join book_copy bc on bc.book_id = b.id " +
         "WHERE bc.available = 'true' " +
         "and b.id = id " + // This is the important condititon
         "GROUP BY b.id)")
private Long nbCopiesAvailable;