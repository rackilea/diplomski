new Thread(new Runnable() {
  public void run() {
    Realm realm = Realm.getDefaultInstance();
    doWork(realm);
    realm.close();
  }
}).start();