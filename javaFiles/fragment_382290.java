getObservable().blockingSubscribe({
    println(it)
}, {
    throw it
}, {
    println("finished")
})