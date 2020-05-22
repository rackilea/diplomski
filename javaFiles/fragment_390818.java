public static <T> Optional<T> findOrEmpty(final DaoRetriever<T> retriever) {
    try {
        return Optional.of(retriever.retrieve());
    } catch (NoResultException ex) {
        //log
    }
    return Optional.empty();
}