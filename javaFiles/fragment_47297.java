class Region private () {
  private val registered = ArrayBuffer.empty[() => Unit]
  def register(finalizer: () => Unit): Unit = registered += finalizer
  def releaseAll(): Unit = {
    registered.foreach(f => f()) // todo - will leak if f() throws
  }
}