private class exampleTask extends AsyncTask<String, Void, SomeResult>{
            SomeResult res;

            @Override
            protected SomeResult doInBackground(String... urls) {

               someMethod(new CallBack<T>(){
                  @Override
                  public void onResponse(SomeResult something) {
                    res = something ; 
                 }

                @Override
                public void onFailure() {
                    //
                }
           });

         return res ;
        }


        @Override
        protected void onPostExecute() {
            //
        }
    }