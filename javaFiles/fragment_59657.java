Call<Result> call = service.getBarcodeList();

    call.enqueue(new Callback<Result>() {

        @Override
        public void onResponse(Call<Result> call, Response<Result> response) {

        Result r = response.body(); // you can initialize result r variable global if you have out side use of this response

        }

        @Override
        public void onFailure(Call<Result> call, Throwable t) {
            Log.d("MyLog", "error " + t.toString());
        }
    });