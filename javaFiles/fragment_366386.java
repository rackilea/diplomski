class CSV(data: List[List[String]]) {

//def make_instance[T: ClassTag]: Option[T] =
  def make_instance[T: ClassTag](args: Seq[String]): Option[T] =
//  classTag[T].runtimeClass.newInstance match {
    classTag[T].runtimeClass.getConstructor(Seq.fill(args.length)(classOf[String]): _*).newInstance(args: _*) match {
      case v: T => Some(v)
      case _ => None
    }

  def get_term[T: TypeTag](term: String) = ru.typeOf[T].decl(ru.TermName(term)).asTerm

  def get_mirror[T: ClassTag] = ru.runtimeMirror(classTag[T].runtimeClass.getClassLoader)

  def extract[T:ClassTag:TypeTag](): List[T] = {
    val header = data.head
    val datas = data.tail
    /*data*/datas.map(row => {
      val res: T = /*make_instance[T].get*/make_instance[T](row).get
      for(i <- 0 /*to*/until row.length) {
        val data_symb = get_term[T](header(i))
        val m = get_mirror[T]
        val im = m.reflect(res)
        val data_mirror = im.reflectField(data_symb)
        data_mirror.set(/*datas*/row(i))
      }
      res
    })
  }
}

case class PlayerData(btag: String, team: String, status: String, role: String)

val p = new CSV(List(
  List("btag", "team", "status", "role"), 
  List("a", "b", "c", "d"), 
  List("a1", "b1", "c1", "d1")
)).extract[PlayerData]

for(PlayerData(b, t, _, r) <- p) {
  println(s"btag: $b, team: $t, role: $r")
}
//btag: a, team: b, role: d
//btag: a1, team: b1, role: d1