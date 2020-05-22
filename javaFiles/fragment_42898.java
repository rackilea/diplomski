class DataToChunkConverter extends Converter[Any,  Array[Byte]] {
  override def convert(obj: Any):  Array[Byte] = {
    if (obj == null) {
      return null
    }
    val abc = obj.asInstanceOf[ABC] 
    val idd = abc.getID()
    idd
  }
}