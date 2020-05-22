new Handler(Looper.getMainLooper()).post(new Runnable() { // <-- if you are not on UI thread and want to go there
    @Override
    public void run() {
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                }
            });
        } finally {
            if(realm != null) {
                realm.close();
            }
        }
    }
});