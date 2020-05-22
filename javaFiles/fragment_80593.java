public Observable<Stuff> listStuff() {
    String sql = <...>;
    return mBriteDatabase.createQuery(Stuff.TABLE_NAME, sql)
      .mapToList(mStuffMapper)
      .doOnsubscribe(() -> Log.d(TAG, ".listStuff() - "+Thread.currentThread().getName()));
}