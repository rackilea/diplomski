subscription = LifecycleObservable.bindActivityLifecycle(lifecycle(),
            AppObservable.bindActivity(this, ViewObservable.clicks(button))
                    .observeOn(Schedulers.computation())
                    .map(new Func1<OnClickEvent, String>() {
                        @Override
                        public String call(OnClickEvent onClickEvent) {
                            Log.i(TAG, "1 " + Thread.currentThread());
                            return ((Button) onClickEvent.view()).getText().toString();
                        }
                    })
                    .map(new Func1<String, String>() {
                        @Override
                        public String call(String o) {
                            Log.i(TAG, "2 " + Thread.currentThread());
                            return "hallo " + o;
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread()))
            .subscribe(new Action1<String>() {
                @Override
                public void call(String s) {
                    Log.i(TAG, "3 " + Thread.currentThread());
                    Log.i(TAG, "s: " + s);
                }
            });