Book b = BOOK.as("b");

create.select(b.TITLE)
  .from(b)
  .where(b.PUBLISHED_IN.eq(2011))
  .orderBy(b.TITLE)