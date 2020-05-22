Callback<List<Animal>> callback = new Callback<List<Animal>>() {
        @Override
        public void success(List<Animal> animals, Response response) {
            if (animals == null) {
            }
            else {
                ListAdapter theAdapter = new MyAdapter(getApplicationContext(), animals);
                theListView.setAdapter(theAdapter);
            }
        }
        @Override
        public void failure(RetrofitError retrofitError) {
            return;
        }
    };