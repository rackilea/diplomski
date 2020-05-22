public void clickButton(View view){
    button = (Button) findViewById(R.id.button);
    drawDate = (TextView)findViewById(R.id.drawDate);

    LotteryAPI.Factory.getIstance().getLottery().enqueue(new Callback<List<Lottery>>() {
        @Override
        public void onResponse(Response<List<Lottery>> response, Retrofit retrofit) {
            Log.e(TAG, response.body()+"");
            for (Lottery lt : response.body()) {
                Log.e(TAG, lt.getDraw_date());
                Log.e(TAG, lt.getMega_ball());
                if (lt.getMultiplier() != null) Log.e(TAG, lt.getMultiplier());
                Log.e(TAG, lt.getWinning_numbers());
            }
                Log.d(TAG, "getting Draw Date");