realm.executeTransactionAsync(new Realm.Transaction() {
  @Override
  public void execute(Realm realm) {
    realm.copyToRealmOrUpdate(dog);  // <-- this is on background thread
  //...


private void setMother(int id) {
   dog.mother = realm.where(Dog.class).equalTo(ID, id).findFirst(); // <-- uses UI-thread Realm stored as field