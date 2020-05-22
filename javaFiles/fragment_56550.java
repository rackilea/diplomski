abstract class BaseItem {
    abstract val id: Int
    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int
}

data class Person(override val id: Int, val name: String) : BaseItem()

data class Product(
        override val id: Int,
        val name: String,
        val cost: BigDecimal
) : BaseItem()