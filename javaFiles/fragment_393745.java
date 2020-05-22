override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Observable.interval(1000L, TimeUnit.MILLISECONDS)
            .timeInterval()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { Log.d("tag", "&&&& on timer") }
    // ...
}