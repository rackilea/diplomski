val keywords = List(/*key words here*/)

val resMap = io.Source
  .fromFile(/*file to read*/)
  .getLines()
  .zipWithIndex
  .foldLeft(Map.empty[String,Seq[Int]].withDefaultValue(Seq.empty[Int])){
    case (m, (line, idx)) =>
      val subMap = line.split("\\W+").toSeq  //separate the words
        .filter(keywords.contains)           //keep only key words
        .groupBy(identity)                   //make a Map w/ keyword as key
        .mapValues(_.map(_ => idx+1))        //and List of line numbers as value
        .withDefaultValue(Seq.empty[Int])
      keywords.map(kw => (kw, m(kw) ++ subMap(kw))).toMap
  }

//formatted results (needs work)
println("keyword\t\tlines\t\tcount")
keywords.sorted.foreach{kw =>
  println(kw + "\t\t" +
          resMap(kw).distinct.mkString("[",",","]") + "\t\t" +
          resMap(kw).length
         )
}