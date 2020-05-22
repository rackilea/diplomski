RealmResults<Graph> graphs = realm.where(Graph.class).findAllAsync();
 graphs.addChangeListener(new RealmChangeListener<RealmResults<Graph>>() {
                    @Override
                    public void onChange(RealmResults<Graph> graphs) {
                        //update UI
                    }
                });