data class Product(val name: String, val aliases: Array<String>)

fun test() {
    val products = listOf<Product>( ... )

    // Do this once, create a map from name and aliases to the product
    val productIndex = products.asSequence().flatMap { product ->
        val allKeys = sequenceOf(product.name) + product.aliases
        allKeys.map { it.toLowerCase() to product }
    }.toMap() 
    // now name => product and each alias => product are mapped in productIndex

    val matchingProduct = productIndex["something"] // search lower case name

    println(matchingProduct?.name ?: "<not found>")
}