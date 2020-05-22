@Suppress("UNCHECKED_CAST")
fun <T : Any> KClass<T>.compareByProperty(propName: String, asc: Boolean = true): Comparator<T> {
    val property = declaredMemberProperties.first { it.name == propName }
    val getter = property::get as (T) -> Comparable<*>

    if (asc) {
        return compareBy(getter)
    }
    return compareByDescending(getter)
}