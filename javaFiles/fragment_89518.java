case class JTest(val dTest: String) {
  lazy val dTestDate: Date = {
    val sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    sdf.parse(dTest)
  }
}