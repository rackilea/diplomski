public void updateData() {
         mListView = (ListView)getView().findViewById(R.id.animal_list);     
   final ParseQuery<Animal> query = ParseQuery.getQuery(Animal.class);


    query.setCachePolicy(CachePolicy.NETWORK_ONLY);
    query.orderByAscending("animal");


    query.setLimit(mListView.getCount() + 5);


    query.findInBackground(new FindCallback<Animal>() {

        @Override
          public void done(List<Animal> animals, ParseException error) {

              if(animals != null){
                  mAdapter.clear();

                mProgressBar = (ProgressBar) getView().findViewById (R.id.loading_animals);
               mProgressBar.setVisibility(View.INVISIBLE);
             RelativeLayout footie = (RelativeLayout) getView().findViewById(R.id.footerview);  
            footie.setVisibility(View.VISIBLE);
                    mAdapter.clear();///////HERE

            for (int i = 0; i < animals.size(); i++) {


                      mAdapter.add(animals.get(i));
                    ArrayList<Animal> animal = new ArrayList<Animal>();
                    animal.add(animals.get(i));






                  }  

              }  
            }
         }); }






     private class RemoteDataTask extends AsyncTask<Void, Void, Void> {


         @Override
            protected void onPreExecute() {
                super.onPreExecute();  }

         @Override
            protected Void doInBackground(Void... params) {

                return null;



         }


         @Override
            protected void onPostExecute(Void result) {


               mListView = (ListView) getView().findViewById(R.id.animal_list);

               mEditText = (EditText) getView().findViewById(R.id.search_animal);

               mAdapter = new AnimalAdapter(getActivity(), new ArrayList<Animal>());

               mListView.setVisibility(View.VISIBLE);
               mListView.setTextFilterEnabled(true);
               mListView.setAdapter(mAdapter);




               mListView.setOnScrollListener(new OnScrollListener() {

                    @Override
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                            int totalItemCount) {
                        final int lastItem = firstVisibleItem + visibleItemCount;
                        if(lastItem == totalItemCount) {




                        if (mListView.getCount() > 20) {

                            RelativeLayout footie = (RelativeLayout) getView().findViewById(R.id.footerview);

                            mListView.removeFooterView(footie);

                              }





                            else{

                                    updateData();
                                }

                            }

                        }

                    }