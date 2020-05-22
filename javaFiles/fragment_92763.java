class BaseClassExample(file: String, mode: String) {
  def this(file: String) = this(file, "mode")
}

class ClassConstExample(file: String, header: String, inType: String, outType: String, flag: String, mode: String) extends BaseClassExample(file, mode) {
  def this(file: String, header: String, inType: String, outType: String, flag: String) = this(file, header, inType, outType, flag, "mode")
  def this(file: String, header: String, flag: String) = this(file, header, "inType", "outType", flag)
}