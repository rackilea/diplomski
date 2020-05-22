for (AuthorDto authorDto : dataAuthorDto) {
    Author author = dataAuthor.findByNameIgnoreCase(authorDto.getName())
    .orElseGet(() -> {
        Author newAuthor = new Author();
        BeanUtils.copyProperties(authorDto, newAuthor);
        return newAuthor;
    });
    dataAuthor.add(author);
}