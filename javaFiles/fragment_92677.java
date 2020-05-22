private class YourAsyncTask extends AsyncTask<String, String, List<Word>> {

    ProgressDialog progressDialog;
    @Override
    protected void onPreExecute() {
        // start loading animation maybe?
        progressDialog = ProgressDialog.show(DictionarySscWords.this,
                "ProgressDialog",
                "Loading all words!");
    }

    @Override
    protected List<Word> doInBackground(String... params) {
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(realmConfig);
        try(realm = realm.getDefaultInstance()) {
            RealmQuery<Word> query = realm.where(Word.class);

            for (int i = 0; i < words_for_ssc[Integer.parseInt(params[0])].length; i++) {
                if (i == words_for_ssc[Integer.parseInt(params[0])].length - 1) {

                    query = query.equalTo("word", words_for_ssc[Integer.parseInt(params[0])][i]);
                } else {
                    query = query.equalTo("word", words_for_ssc[Integer.parseInt(params[0])][i])
                            .or();

                }

            }
            // Here's the sort. Use findAllSorted instead.
            // You can change Sort.ASCENDING to Sort.DESCENDING to reverse 
            // the order.
            sscresult = query.findAllSorted("word", Sort.ASCENDING); 

            // This is where the magic happens. realm.copyFromRealm() takes 
            // a RealmResult and essentially returns a deep copy of the 
            // list that it contains. The elements of this list is however 
            // completely detached from realm and is not monitored by realm 
            // for changes. Thus this list of values is free to move around 
            // inside any thread.

            ArrayList<Word> safeWords = realm.copyFromRealm(sscresult);
            realm.close();
            return safeWords;
        }
    }

    @Override
    protected void onPostExecute(List<Word> words) {
        progressDialog.dismiss();

        // Please note here MyAdaptor constructor will now take the 
        // list of words directly and not RealmResults so you slightly 
        // modify the MyAdapter constructor.

        list.setAdapter(new MyAdapter(words)); 

    }
}