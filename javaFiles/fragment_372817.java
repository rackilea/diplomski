CloseableIterator<Account> iterator = accountDao.closeableIterator();
try {
    while (iterator.hasNext()) {
        Account account = iterator.next();
        ...
    }
} finally {
    iterator.close();
}