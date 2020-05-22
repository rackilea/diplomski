fun <R> timeoutHandled(block: () -> R): R {
    try {
        return block()
    } catch (e: IOException) {
        //Some toast for network timeout for example
    }
}