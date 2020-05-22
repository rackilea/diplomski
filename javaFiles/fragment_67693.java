private Subscription mSubscription;

@Override
protected void onResume() {
    super.onResume();
    mSubscription = Observable.create(new OnSubscribe<Integer>() {
        @Override
        public void call(Subscriber<? super Integer> subscriber) {
            findViewById(R.id.rx_button).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    subscriber.onNext(1);
                }
            });
        }
    }).buffer(2, TimeUnit.SECONDS)
            .subscribe(new Action1<List<Integer>>() {
                @Override
                public void call(List<Integer> integers) {
                    Log.i("TAG", String.valueOf(integers.size()));
                }
            });
}

@Override
protected void onPause() {
    super.onPause();
    mSubscription.unsubscribe();
}