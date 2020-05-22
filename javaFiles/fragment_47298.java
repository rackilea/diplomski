object Region {
  def run[A](f: Region => A): A = {
    val r = new Region
    try f(r) finally r.releaseAll()
  }
}