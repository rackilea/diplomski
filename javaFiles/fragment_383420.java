private void load(int index){

    // TODO: getContext ... shared preferences... 
    String email = prefs.getString("email");
    Call<List<Variabili_Main>> call = api.getHome(email, index);

    call.enqueue(new Callback<List<Variabili_Main>>() {
        @Override
        public void onResponse(Call<List<Variabili_Main>> call, Response<List<Variabili_Main>> response) {
            if(response.isSuccessful()){
                movies.addAll(response.body());
                adapter.notifyDataChanged();
            }else{
                Log.e(TAG," Response Error "+String.valueOf(response.code()));
            }
        }

        @Override
        public void onFailure(Call<List<Variabili_Main>> call, Throwable t) {
            Log.e(TAG," Response Error "+t.getMessage());
        }
    });
}