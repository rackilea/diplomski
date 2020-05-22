Observable.defer(new Func0<Observable<Page>>() {
        @Override
        public Observable<Page> call() {
            return Observable.from(Utility.getPagesFromServer());
        }
    })
    .map(new Func1<Page, JSONResponse>() {
        @Override
        public JSONResponse call(Page page) {
            return Utility.getJSONObjectContainingLines(page);
        }
    })
    .map(new Func1<JSONResponse, ArrayList<Line>>() {
        @Override
        public ArrayList<Line> call(JSONResponse jsonResponse) {
            return getLines(jsonResponse.getJSONObject());
        }
    })
    .flatMapIterable(new Func1<ArrayList<Line>, Iterable<Line>>() {
        @Override
        public Iterable<Line> call(ArrayList<Line> lines) {
            return lines;
        }
    })
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(new Action1<Line>() {
        @Override
        public void call(Line line) {
            //Do something with your line
        }
    }, new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            throwable.printStackTrace();
        }
    }, new Action0() {
        @Override
        public void call() {
            //on complete
        }
    });