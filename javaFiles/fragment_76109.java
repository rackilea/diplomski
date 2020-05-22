@Override
            public void onReceive(Context context,Intent intent) {
                latData=String.valueOf(intent.getExtras().get("lat"));
                langData=String.valueOf(intent.getExtras().get("lang"));

                user.lang= Float.parseFloat(langData);
                user.lat= Float.parseFloat(latData);

                Webservice.getInstance().getApi().UpdateuserLocation(user).enqueue(new Callback<MainResponse>() {
                     @Override
                     public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                     }

                     @Override
                     public void onFailure(Call<MainResponse> call, Throwable t) {
                     }
                });
            }