realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Graph graph = MyFactory.INSTANCE.getGraph();
                bgRealm.insert(graph);
            }
        });