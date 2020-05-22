val sum: AtomicInteger = new AtomicInteger(0)
 for (_ <- 1 to 10000) {
    new Thread(new Runnable {
        override def run() = sum.addAndGet(10)
    }).start()
 }
 // wait threads
 println(sum)