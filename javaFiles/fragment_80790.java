Disposable disposable = Observable.concat(Arrays.asList(
        Observable.just("start").doOnSubscribe(disposable1 -> Log.d("Subscribe", "start")),
        Observable.just("0").delay(3, TimeUnit.SECONDS).doOnSubscribe(disposable1 -> Log.d("Subscribe", "0")),
        Observable.just("1").delay(2, TimeUnit.SECONDS).doOnSubscribe(disposable1 -> Log.d("Subscribe", "1")),
        Observable.just("2").delay(1, TimeUnit.SECONDS).doOnSubscribe(disposable1 -> Log.d("Subscribe", "2")),
        Observable.just("end").doOnSubscribe(disposable1 -> Log.d("Subscribe", "end"))
))
        .subscribe(s -> Log.d("Result", s));

// 2019-01-04 12:45:13.364 31887-31887/ D/Subscribe: start
// 2019-01-04 12:45:13.364 31887-31887/ D/Result: start
// 2019-01-04 12:45:13.364 31887-31887/ D/Subscribe: 0
// 2019-01-04 12:45:16.366 31887-32529/ D/Result: 0
// 2019-01-04 12:45:16.367 31887-32529/ D/Subscribe: 1
// 2019-01-04 12:45:18.367 31887-32535/ D/Result: 1
// 2019-01-04 12:45:18.368 31887-32535/ D/Subscribe: 2
// 2019-01-04 12:45:19.369 31887-32537/ D/Result: 2
// 2019-01-04 12:45:19.371 31887-32537/ D/Subscribe: end
// 2019-01-04 12:45:19.372 31887-32537/ D/Result: end