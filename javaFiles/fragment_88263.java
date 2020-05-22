Book book = assembleBook(input);

for(String authorName: input.getAuthors){
    Author author = repository.getAuthorByName(authorName);

    if(author == null){
       author = new Author(authorName);
    }

    author.getBooks().add(book);

    book.getAuthors.add(author);
}