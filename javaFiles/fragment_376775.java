public void getLastTenMessageCallBack(int user_id, int sender_id, int offset_number, RESTDatabaseDAO service) {
     Call<ArrayList<Message>> call = service.getLastTenMessage(user_id, sender_id, offset_number);
     call.enqueue(new Callback<ArrayList<Message>>() {
          @Override
          public void onResponse(Call<ArrayList<Message>> call, Response<ArrayList<Message>> response) {
               if (response.isSuccess()) {
           // THIS IS BEING CALLED AFTER YOUR METHODS RETURNS, SO UPDATE YOUR VIEWS LIKE THIS.

            updateViews(response.body());
            Log.i("Success", "Good ten " + response.body().size());
        } else {
            Log.i("Success", "Not good  ten" + response.raw());
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Message>> call, Throwable t) {
        Log.i("Fail", "Failure ten " + t.toString());
    }
   });


}
public void updateViews(List<Messages> messages){
    //use messages to update your views here.
}