private void getData(NewsSettings newsSettings) {  // remove int return type

   .....
   .....

   response.enqueue(new Callback <ServerResponse>() {
      @Override
      public void onResponse(Call <ServerResponse> call,
                           retrofit2.Response <ServerResponse> response) {
          ServerResponse resp = response.body();
          Toast.makeText(getApplicationContext(), "Inside Response", Toast.LENGTH_SHORT).show();

          if(resp.getResult().equals(Constants.SUCCESS)) {
              data[0] = resp.getNewsSettings().getDataCount();

           /** here is the modification ***/
              displayDataCount(data[0]);  // call to displayCount() method

              Toast.makeText(getApplicationContext(), "Data count = " + data[0], Toast.LENGTH_LONG).show();
          }
      }

      @Override
      public void onFailure(Call <ServerResponse> call, Throwable t) {
          Log.d(Constants.TAG,"failed");
          Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
      }
  });

}