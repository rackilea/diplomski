object Test {

  def main(args:Array[String]):Unit={
    val source = scala.io.Source.fromFile("/ssd2/test.txt")
    val lines = source.getLines().toList
    val (header, payload) = (lines.take(6), lines.drop(6))

    def classify(i:Int):Int = (i / 10) + 1

    val binned = payload.map{line =>
      line.split(" ").map(n => classify(n.toInt)).mkString(" ")
    }

    val result = header ++ binned
    result.foreach(println(_))
  }

}