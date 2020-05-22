private void setMother(Realm realm, Dog dog, int id) {
   dog.mother = realm.where(Dog.class).equalTo(ID, id).findFirst();
  }

  private void saveDog() {
   realm.executeTransactionAsync(new Realm.Transaction() {
      @Override
      public void execute(Realm realm) {
        Dog _dog = realm.copyToRealmOrUpdate(dog);
        setMother(realm, _dog, id);
      }
    });