SELECT
  author.*,
  MULTISET(
    SELECT * FROM book WHERE book.author_id = author.id
  ) AS books
FROM author;