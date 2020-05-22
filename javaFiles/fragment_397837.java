// Kotlin:
fun call(function: (Int) -> Int, arg: Int): Int = function(arg)
fun call(function: Function<Int, Int>, arg: Int): Int = call(toKotlin(function), arg)

// Java:
ExampleKt.call(x -> 3 * x, 42);