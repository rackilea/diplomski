realm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            realm.createObjectFromJson(BaseObject.class, json);
        }
    });