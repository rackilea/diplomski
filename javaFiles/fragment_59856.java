subscription = RxTextView
            .textChangeEvents(editText)
            .debounce(400, TimeUnit.MILLISECONDS)
            .map(new Func1<TextViewTextChangeEvent, String>() {
                @Override
                public String call(TextViewTextChangeEvent textViewTextChangeEvent) {
                    return textViewTextChangeEvent.text();
                }
            })
            .flatMap(new Func1<String, Observable<CatFactsResponse>>() {
                @Override
                public Observable<CatFactsResponse> call(String text) {
                    return restClient.getCatFacts(text)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                }
            })
            .subscribe(...);