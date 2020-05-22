if (response.isSuccess()) {
  if(networkResponseCallback!=null)
       networkResponseCallback.onSuccess(response.body());


public void onFailure(Call<ArrayList<Message>> call, Throwable t) {
    Log.i("Fail", "Failure ten " + t.toString());
    networkResponseCallback.onFailure();
}