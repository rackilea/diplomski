CloseableWrappedIterable<Account> wrappedIterable =
    accountDao.getWrappedIterable();
try {
    for (Account account : wrappedIterable) {
        ...
    }
} finally {
    wrappedIterable.close();
}