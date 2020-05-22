class SynchronousExceptionExamples {
    @Test
    fun example() {
        log.info("before launch")
        val job = GlobalScope.launch(Dispatchers.Unconfined) {
            log.info("before throw")
            throw Exception("an-error")
        }
        log.info("after launch")
        Thread.sleep(1000)
        assertTrue(job.isCancelled)
    }
}