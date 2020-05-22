fun methodA() {
    val err = methodB()
    if (err) {
        // error flow
    } else {
        // normal flow
    }
}

fun methodB(): Boolean {
    return methodC()
}

fun methodC(): Boolean {
    return try {
        // do something that can throw exception
        false
    } catch (e: IOException) {
        true
    }
}