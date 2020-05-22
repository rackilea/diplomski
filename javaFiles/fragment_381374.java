enum class Test(val type: List<String>) {
    A(listOf("aa", "ab", "ac")),
    B(listOf("bb", "bc", "bd")),
    C(listOf("aa", "bb", "dd"));

    companion object {
        private val normalizedValues = values().flatMap { value ->
                value.type.map { "${value.name}.$it" }
            }
        fun listAll() = normalizedValues
        fun search(type: String?) = normalizedValues.contains(type)
    }
}

fun main() {
    println(Test.listAll())
    println(Test.search("B.bd"))
    println(Test.search("B.ad"))
}