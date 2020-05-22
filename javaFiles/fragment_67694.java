@Override
protected void onResume() {
    super.onResume();
    mSubscription = Observable.create((Subscriber<? super Integer> subscriber) ->
            findViewById(R.id.rx_button).setOnClickListener(view ->
                    subscriber.onNext(1))).buffer(2, TimeUnit.SECONDS)
            .subscribe(integers -> Log.i("TAG", String.valueOf(integers.size())));
}