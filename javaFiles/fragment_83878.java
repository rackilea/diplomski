Call<CryptoCurrency> call = mCurrencyInterface.currency("BTC", "NGN");

call.enqueue(new Callback<CryptoCurrency>() {
        @Override
        public void onResponse(Call<CryptoCurrency> call, Response<CryptoCurrency> response) {
            BTC btc = response.body().getBTC();
            Toast.makeText(getApplicationContext(), "result " + btc.getNGN(), Toast.LENGTH_LONG).show();

        }

        @Override
        public void onFailure(Call<CryptoCurrency.BTC> call, Throwable t) {

        }
    });