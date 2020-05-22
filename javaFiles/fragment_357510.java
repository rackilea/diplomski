private typealias KotlinPredicate<T> = (T) -> Boolean;

private typealias KotlinConsumer<T> = (T) -> Unit;

class DatabaseManager {
    private interface Consumer<T> {
        fun apply(t : T) : Unit;
    }

    private fun forEachLiveList(consumer: Consumer<MutableLiveList<*>>) {
        forEachLiveList({
            consumer.apply(it)
        })
    }

    private fun forEachLiveList(consumer: KotlinConsumer<MutableLiveList<*>>) {
        ...
    }