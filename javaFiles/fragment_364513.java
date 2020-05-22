object KafkaOwner {
  private var producer: KafkaProducer = ???
  @volatile private var isClosed = false

  def close(): Unit = {
    if (!isClosed) {
      kafkaProducer.close()
      isClosed = true
    }
  }

  def instance: KafkaProducer = {
    this.synchronized {
      if (!isClosed) producer 
      else {
        producer = new KafkaProducer()
        isClosed = false
      }
    }
  }
}