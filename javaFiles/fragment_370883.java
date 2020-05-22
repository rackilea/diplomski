class SomethingSyncd {
    @Synchronized fun syncFoo() {

    }

    val myLock = Any()

    fun foo() {
        synchronized(myLock) {
            // ... code
        }
    }

    @Volatile var thing = mapOf(...)
}