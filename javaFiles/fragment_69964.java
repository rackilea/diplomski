object TestCommonResource {
    private val logger = LoggerFactory.getLogger(TestCommonResource::class.java)
    @JvmStatic
    fun main(args: Array<String>) {
        val queue = Flowable.fromIterable(1..5)
        val resIdx = AtomicInteger(0)
        val result = Single.using({
            val res = "resource-${resIdx.incrementAndGet()}"
            logger.info("Init resource $res")
            res
        }, { res ->
            queue.flatMapSingle({ item ->
                Single.fromCallable {
                    logger.info("Process $item with $res")
                    "$item @ $res"
                }
                        .subscribeOn(Schedulers.io())
            }, false, 2)
                    .toList()
        }, { res ->
            logger.info("Dispose resource $res")
        }, false)
                .blockingGet()
        logger.info("Result: $result")
    }
}