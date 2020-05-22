public Observable<TickerResponse> getTicker(YobitPublic api, String first_coin, String second_coin) {
    Call<JsonObject> call = api.getTickerObservable(first_coin + "_" + second_coin);
    return Observable.create( emitter -> {
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d(TAG, "Response code: " + response.code());
                JsonObject jsonObject = response.body();
                Gson gson = new Gson();
                TickerResponse tickerResponse;
                Set<Map.Entry<String,JsonElement>> set = jsonObject.entrySet();
                for (Map.Entry<String,JsonElement> obj : set) {
                    String key = obj.getKey();
                    if (jsonObject.get(key) != null) {
                        TickerPoint point = gson.fromJson(jsonObject.get(key).toString(), TickerPoint.class);
                        if (point != null && point.getServer_time() != 0) {
                            tickerResponse = new TickerResponse(key, point);
                            emitter.onNext(tickerResponse);
                            emitter.onComplete();
                            return;
                        }
                    }
                }
                emitter.onError(new Throwable("Error"));
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                emitter.onError(t);
            }
        });
    });

}