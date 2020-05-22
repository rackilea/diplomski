val source1 = Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

val source2 = Observable.interval(3000, TimeUnit.MILLISECONDS)

val observable = Observable.zip(source1, source2, object : BiFunction<String, Long, Any> {
    override fun apply(t1: String, t2: Long): Any {
        Log.d("Sometag", "Received $t1")
        return "Something"
    }
}).subscribe()