@Component
class KafkaScheduler() {
    @Autowired
    lateinit var queueListener: QueueListener

    @Autowired
    lateinit var prefetchListener: PrefetchListener

    @Autowired
    lateinit var fetchListener: FetchListener

    @PostConstruct
    fun init() {
        val threads = arrayOf(
            {
                queueListener.init()
            },
            {
                prefetchListener.init()
            },
            {
                fetchListener.init()
            }
        )

        val service = Executors.newFixedThreadPool(threads.size)

        for (thread in threads) {
            service.submit(thread)
        }
    }
}