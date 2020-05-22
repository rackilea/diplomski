new Handler(Looper.getMainLooper()).post(new Runnable() {  // <-- if you are not on UI thread and want to go there
    @Override
    public void run() {
          final Realm realm = Realm.getDefaultInstance();
          realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                }
            }, 
            new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    realm.close();
                }
            }, 
            new Realm.Transaction.OnError() {
                @Override
                public void onError(Throwable e) {
                    realm.close();
                }
            });
    }
});