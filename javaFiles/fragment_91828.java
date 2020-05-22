Observable<Result> validationResultObservable = Observable.combineLatest(headers, feildValues, new Func2<String, String, Result>() {
            @Override
            public Result call(String header, String field) {
                // header always same
                // field always new
                // validate, create same kind of Result object or just a boolean
                Log.i("TEST_IT", "validationResultObservable emitted: " + header + " - " + field);
                return new Result(header, field);
            }
        });