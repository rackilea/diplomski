object ThreadsMain extends App {
  val syncVar = new SyncVar[Int]()
  val isDone = new AtomicBoolean(false)

  val producer = new Thread {
    override def run(): Unit = {
      for (x <- 1 to 15) {
        syncVar.synchronized {
          while (!syncVar.isEmpty) {
            syncVar.wait()
          }
          syncVar.put(x)
          syncVar.notify()
        }
      }
      isDone.set(true)
    }
  }

  producer.start()

  val consumer = new Thread {

    override def run(): Unit = {
      while (!isDone.get()) {
        syncVar.synchronized {
          while (syncVar.isEmpty) {
            syncVar.wait()
          }
          println(syncVar.get())
          syncVar.notify()
        }
      }
    }
  }

  consumer.start()

  producer.join()

  consumer.join()
}

class SyncVar[T]() {
  var isEmpty: Boolean = true
  var value: Option[T] = None

  def get(): T = {
    if (isEmpty) throw new Exception("Get from empty SyncVar")
    else {
      val toReturn = value.get
      value = None
      isEmpty = true
      toReturn
    }
  }

  def put(x: T): Unit = {
    if (!isEmpty) throw new Exception("Put on non-empty SyncVar")
    else {
      value = Some(x)
      isEmpty = false
    }
  }
}