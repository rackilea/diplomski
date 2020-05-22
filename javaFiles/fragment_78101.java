public void RequestGR(LatLng start, LatLng end, final Callback<JSONArray> arrayCallback)
    {

        EndpointInterface loginService = ServiceAuthGenerator.createService(EndpointInterface.class);    
        Call<GR> call = loginService.getroutedriver();
        call.enqueue(new Callback<GR>() {
            @Override
            public void onResponse(Response<GR> response , Retrofit retrofit)
            {

                 JSONArray jsonArray_GR = response.body().getRoutes();
                 arrayCallback.onResponse(jsonArray_GR);
            }
            @Override
            public void onFailure(Throwable t) {
               // error handling? arrayCallback.onFailure(t)?
            }
        });
    }