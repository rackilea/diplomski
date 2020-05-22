private val consumers = mutableMapOf<Class<*>, Any>()

@PublishedApi
internal fun <T> putConsumer(clazz: Class<out T>, consumer: (T) -> Unit) {
    consumers.put(clazz, consumer)
}

inline fun <reified T> consumerFor(noinline consumer: (T) -> Unit): C {
    putConsumer(T::class.java, consumer)
    return this
}