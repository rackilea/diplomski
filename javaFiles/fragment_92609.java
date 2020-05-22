getActivity().runOnUiThread(new Runnable() {
  @Override
  public void run() {
     if (status) {
    //will execute if status is true
    }else{
    //will execute if status is false
    Toast.makeText(getContext(), "Hello" + jsonObject1.get("message").toString(), Toast.LENGTH_SHORT).show();
    }
});