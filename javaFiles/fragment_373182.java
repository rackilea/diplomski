cardDao.callBatchTasks(new Callable<Void>() {
    public Void call() throws Exception {
        for (Card card : cardsList) {
            cardDao.update(card);
        }
    }
});