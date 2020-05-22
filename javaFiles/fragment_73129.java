private class exampleTask extends AsyncTask<String, Void, SomeResult>{
    SomeResult res;

    @Override
    protected SomeResult doInBackground(String... urls) {

       // background work
    }


    @Override
    protected void onPostExecute() {
       someMethod(new CallBack<T>(){
              @Override
              public void onResponse(SomeResult something) {
                res = something ;
               // DO STUFF WITH RES HERE AFTER IT'S BEEN ASSIGNED OR YOU WON'T HAVE ACCESS TO IT
             }

            @Override
            public void onFailure() {
                //
            }
       });
    }

}