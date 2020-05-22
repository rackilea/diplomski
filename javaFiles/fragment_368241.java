RealmConfiguration config = new RealmConfiguration.Builder().initialData(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int i = 1;
                for (Map.Entry entry : map.entrySet()) {
                    Category c = realm.createObject(Category.class, i++);
                    c.setName((String) entry.getKey());
                    c.setDescription("Category #" + entry.getValue());
                }
            }
        }