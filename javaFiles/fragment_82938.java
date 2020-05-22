@PublishedApi
internal val consumers = mutableMapOf<Class<*>, Any>()

inline fun <reified T> consumerFor(noinline consumer: (T) -> Unit): C {
    consumers.put(T::class.java, consumer)
    return this
}