RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                                            .schemaVersion(11)
                                            .migration(new MyMigration())
                                            ./*...*/.build();
Realm.setDefaultConfiguration(realmConfiguration);
DynamicRealm dynamicRealm = DynamicRealm.getInstance(realmConfiguration);
long schemaVersion = dynamicRealm.getVersion();
dynamicRealm.close();
if(schemaVersion < 11) {
    Realm.deleteRealm(realmConfiguration);
}
Realm realm = Realm.getDefaultInstance(); // should work now