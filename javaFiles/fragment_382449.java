Observable<ArrayList<Item>> observable = Observable.interval(5, TimeUnit.SECONDS)
            .map(new Func1<Long, ArrayList<Item>>() {

                @Override
                public ArrayList<Item> call(Long aLong) {
                    return new ArrayList<Item>(aLong.intValue());
                }
            });
    Subscription subscription = observable.subscribe(new Action1<ArrayList<Item>>() {
        @Override
        public void call(ArrayList<Item> items) {
            //Do something with list items here
        }
    });