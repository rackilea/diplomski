interface Predicate<T> {
    fun test(t : T) : Boolean;
}


fun updateLiveLists(predicate: Predicate<MutableLiveList<*>>) {
    updateLiveLists({
        predicate.test(it)
    })
}

fun updateLiveLists(predicate: KotlinPredicate<MutableLiveList<*>> = { liveList -> true }) {
    forEachLiveList({ liveList ->
        if (predicate.invoke(liveList)) {
            refresh(liveList)
        }
    })
}