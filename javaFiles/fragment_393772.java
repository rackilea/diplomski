while(it.hasNext()) {
    val delayedMessage = it.peek().message()
    if(delayedMessage.delayTo < getCurrentTime()) {
        val readMessage = it.next().message
        process(readMessage.originalMessage)
        consumer.commitOffset()
    } else {
        delayProcessingUntil(delayedMessage.delayTo)
    }
}