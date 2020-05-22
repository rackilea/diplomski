class MyClass {
    companion object {
        val log = loggerFor<MyClass>()
    }

    fun usage() {
        log.debug("Success")
    }
}