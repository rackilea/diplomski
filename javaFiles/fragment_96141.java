fun methodA() {
    try {
        methodB()
    } catch (e: IOException) {
        // error flow
    }
}

@Throws(IOException::class)
fun methodB() {
    methodC()
}

@Throws(IOException::class)
fun methodC() {
    // do something that can throw exception
}