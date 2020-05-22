try {
  var dataInStream: DataInputStream = null
  //Open the file and set up the DataInputStream
  val f = new File(pCapFileName)
  if (f.getAbsoluteFile.exists) {
    val fis = new FileInputStream(f)
    dataInStream = new DataInputStream(fis)
    val dnsPcapReader = new DnsPcapReader(dataInStream)
    val pktIter = dnsPcapReader.iterator
    var counter = 0
    while (pktIter.hasNext) {
      counter += 1
      if (counter % 100 == 0) println(counter)
      val pCapFile = pktIter.next.asInstanceOf[DnsPacket]
      for (i <- 0 until types.length) {
        val tuple = types(i)
        val fieldName = tuple._1
        var className = Option(pCapFile.get(fieldName)).map(_.getClass).toString
        var numOccurances = tuple._3
        if(className.equals("None"))
          className = tuple._2.asInstanceOf[String]
        else
          numOccurances += 1
        val newTuple = (fieldName, className, numOccurances)
        types = types.updated(i, newTuple)
      }
    }
  }
  for {
    tuple <- types
  } printf("%s%-25s%-25s%-25s\n%s\n", "\t", tuple._1 + ":", tuple._2,
    "[" + tuple._3 + "]", spacer)
  //Close the stream
  dataInStream.close
} catch {
  case e: Exception => e.printStackTrace()
}