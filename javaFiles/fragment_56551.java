abstract class BaseItem {
    abstract val id: Int
    override fun equals(other: Any?) = (other is BaseItem) && id == other.id
    override fun hashCode() = id
}

class Person(override val id: Int, val name: String) : BaseItem() {
    override fun equals(other: Any?): Boolean {
        return (other is Person) && id == other.id && name == other.name
    }

    override fun hashCode() = 31 * (31 + id.hashCode()) + name.hashCode()
}

class Product(
        override val id: Int,
        val name: String,
        val cost: BigDecimal
) : BaseItem()

fun main(args: Array<String>) {
    val baseItem1: BaseItem = Person(1, "Oliver")
    val baseItem2: BaseItem = Product(1, "grease", BigDecimal.TEN)
    println(baseItem1 == baseItem2) // false
    println(baseItem2 == baseItem1) // true
}