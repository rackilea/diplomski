fun mainMethod(m: String, functionAsParam: (m: String) -> Unit) {
    functionAsParam(m)
}

// my function to pass into the other
fun functionAsParam(m: String) {
    println("my message: $m")
}