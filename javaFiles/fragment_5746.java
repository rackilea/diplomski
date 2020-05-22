// OnCreate
    DynamicRealm realm = DynamicRealm.getInstance(realmConfig);
    RealmSchema schema = realm.getSchema();
    List<RealmResults<DynamicRealmObject>> strongRefs = new ArrayList<>();
    for (final RealmObjectSchema classSchema : schema.getAll()) {
        // Create a RealmResults for all elements in a Table
        RealmResults<DynamicRealmObject> result = realm.where(classSchema.getClassName()).findAll();
        // Register a changelistener for that realm result
        result.addChangeListener(new RealmChangeListener<RealmResults<DynamicRealmObject>>() {
            @Override
            public void onChange(RealmResults<DynamicRealmObject> element) {
                Intent intent = new Intent("custom-event-name");
                intent.putExtra("classChanged", classSchema.getClassName());
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
            }
        });
        strongRefs.add(result); // Make sure that RealmResults are not GC'ed
    }


    // onDestroy
    for (RealmResults<DynamicRealmObject> strongRef : strongRefs) {
        strongRef.removeChangeListeners();
    }