source
.observeOn(Schedulers.computation())
.map(v -> heavyCalculation(v))
.observeOn(Schedulers.io())
.doOnNext(v -> { saveToDB(v); })
.observeOn(AndroidSchedulers.mainThread())
...