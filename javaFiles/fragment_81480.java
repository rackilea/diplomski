private <E extends Model> void get(DataAccessor<E, ?> accessor);
    accessor.get(0, this, new DataAccessor.Listener<Data<E>>() {
        @Override
        public void onResponse(Data<E> value) {
            //...
        }
    }, this);
}