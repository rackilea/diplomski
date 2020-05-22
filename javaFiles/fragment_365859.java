open class Base {
    open val value: List<Int> = ArrayList()
}

val b : Base = foo()

fun printArrayList(list: ArrayList<Int>) { /* ... */ }

if (b.value is ArrayList) { // first call
    printArrayList(b.value) // second call, smart cast is impossible
}