import io.reactivex.Observable

data class Entity(val id: Int)
data class Dto(val id: Int)

sealed class Either<out A, out B>
data class Left<A>(val value: A) : Either<A, Nothing>()
data class Right<B>(val value: B) : Either<Nothing, B>()

fun <A : Any, B : Any, C> joinById(a: Observable<A>, idA: (A) -> C, b: Observable<B>, idB : (B) -> C): Observable<Pair<A?, B?>> {
    val unmatchedA = mutableMapOf<C, A>()
    val unmatchedB = mutableMapOf<C, B>()
    val merged = Observable.mergeDelayError(a.map(::Left), b.map(::Right)).flatMap { latest ->
        when (latest) {
            is Left -> {
                val id = idA(latest.value)
                unmatchedB.remove(id)?.let { return@flatMap Observable.just(latest.value to it) }
                unmatchedA.put(id, latest.value)
            }
            is Right -> {
                val id = idB(latest.value)
                unmatchedA.remove(id)?.let { return@flatMap Observable.just(it to latest.value) }
                unmatchedB.put(id, latest.value)
            }
        }
        Observable.empty<Nothing>()
    }
    return Observable.concat(merged, Observable.create { emitter ->
        unmatchedA.values.forEach { emitter.onNext(it to null) }
        unmatchedB.values.forEach { emitter.onNext(null to it) }
        emitter.onComplete()
    })
}

fun main(args: Array<String>) {
    val entities = Observable.just(Entity(2), Entity(1), Entity(4))
    val dtos = Observable.just(Dto(3), Dto(2), Dto(1))
    joinById(entities, Entity::id, dtos, Dto::id).blockingForEach(::println)
}