//...
fun doBackgroundStuff(thing: RenderableThing): Future<Stuff> {
    L.L.get(thing)?.cancel(true)
    val cache = thing.cache()
    val f = pool.submit {
        try {
            thing.lock()
            // Do long running I/O task on cache
        } finally {
            thing.unlock()
        }
    }
    L.L.put(thing, f)
    return f
}
//...

object L {
    val L: IdentityHashMap<RenderableThing, Future<Stuff>>  ? = IdentityHashMap<>()
}