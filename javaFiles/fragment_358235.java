val countDownLatch = CountDownLatch(1)

// Execute your request

countDownLatch.countDown()

try {
    countDownLatch.await(30, TimeUnit.SECONDS) // Give it a 30 seconds timeout
    // return the response code here.
} catch (ex: InterruptedException) {
    // Catch the timeout exception
}