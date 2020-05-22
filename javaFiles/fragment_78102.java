public BlockingQueue<JSONArray> RequestGR(LatLng start, LatLng end)
    {
        // You can create a final container object outside of your callback and then pass in your value to it from inside the callback.
        final BlockingQueue<JSONArray> blockingQueue = new ArrayBlockingQueue<>(1);
        EndpointInterface loginService = ServiceAuthGenerator.createService(EndpointInterface.class);    
        Call<GR> call = loginService.getroutedriver();
        call.enqueue(new Callback<GR>() {
            @Override
            public void onResponse(Response<GR> response , Retrofit retrofit)
            {

                 JSONArray jsonArray_GR = response.body().getRoutes();
                 blockingQueue.add(jsonArray_GR);
            }
            @Override
            public void onFailure(Throwable t) {
            }
        });
        return blockingQueue;
    }