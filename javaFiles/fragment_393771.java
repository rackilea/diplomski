while(it.hasNext()) {
    val message = it.next().message()

    if(shouldBeDelayed(message)) {
        val delay = 24 hours
        val delayTo = getCurrentTime() + delay
        putMessageOnDelayedQueue(message, delay, delayTo)
    }
    else {
       process(message)
    }

    consumer.commitOffset()
}