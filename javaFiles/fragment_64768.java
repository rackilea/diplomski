object MyInputStream extends InputStream {
  val readLock = new AnyRef
  var readFlag = false
  var data = ArrayBuffer.empty[Byte]
  data.append("ls\n".map(_.toByte): _*)
  new Thread(() => {
    Thread.sleep(5 * 1000)

    data.append("pwd\n".map(_.toByte): _*)
    readied = true
    lock.synchronized(lock.notify())

  }).start()

  var dataIndex = 0

  val lock = new AnyRef
  var readied = true
  override def read(): Int = {
    if(!readied) {
      lock.synchronized(lock.wait())
    }
    val rst = if(dataIndex < data.length) {
      val a = data(dataIndex)
      dataIndex += 1
      a
    }
    else {
      readied = false
      -1

    }


    println("read - " + rst)

    rst
  }
}