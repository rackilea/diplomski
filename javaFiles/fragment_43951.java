fun main() {
    val typeObjects = listOf(...)
    val comparator = TypeObject::class.compareByProperty("id")
        .thenByProperty("type", asc = false)

    val sortedTypes = typeObjects.sortedWith(comparator)
}