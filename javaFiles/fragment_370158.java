List<Author> authors = dsl.selectFrom(AUTHOR)
                          .fetchInto(Author.class);

Map<String, List<Book>> booksByAuthorId = dsl.selectFrom(BOOK)
                                             .fetchMap(BOOK.AUTHOR_ID, Book.class);

return authors.stream()
    .map(author -> new Author(author.getId(),
                              author.getName(),
                              booksByAuthorId.getOrDefault(author.getId(), emptyList())))
    .collect(Collectors.toList());