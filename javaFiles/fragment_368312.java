private static final Map<Character, BiConsumer<Book, String>> CODE_TO_SETTER =
    new HashMap<>();

static
{
    CODE_TO_SETTER.put('*', Book::setTitle);
    CODE_TO_SETTER.put('@', Book::setAuthor);
    // plus any others you want
}