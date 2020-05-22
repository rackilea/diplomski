data class Product(val name: String, val aliases: Array<String>)

// written as an extension function, but doesn't have to be...
fun List<Product>.isProductOrAlias(text: String): String {
   return this.firstOrNull { product -> 
       product.name.equals(text, ignoreCase = true) ||
       product.aliases.any { alias -> 
           alias.equals(text, ignoreCase = true)
       }
   }?.name ?: ""
}

fun test() {
   // assume somewhere this was created
   val products = listOf<Product>(...)

   println(products.isProductOrAlias("something")) // prints name of Product or ""
}