val nulls = arrayOfNulls<String>(size) //equivalent in Java: new String[size]
val strings = Array(size) { "n = $it" } 
val myStrings = arrayOf("foo", "bar", "baz")

val boxedInts = arrayOfNulls<Int>(size) //equivalent in Java: new Integer[size]
val boxedZeros = Array(size) { 0 }