public Post getPost(final Integer key) throws SQLException, IOException {
    try {
        return cache.get(key, new Callable<Post>() {
            @Override
            public Post call() throws Exception {
                return PostsDB.findPostByID(key);
            }
        });
    } catch (ExecutionException e) {
        Throwables.propagateIfPossible(
            e.getCause(), SQLException.class, IOException.class);
        throw new IllegalStateException(e);
    } catch (UncheckedExecutionException e) {
        Throwables.throwIfUnchecked(e.getCause());
        throw new IllegalStateException(e);
    }
}