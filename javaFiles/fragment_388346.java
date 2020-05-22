implicit class SQLInterpolation(val sc : StringContext) extends AnyVal {

  def sql(args: Any*) : SQL = 
    DSL.sql(string, args.asInstanceOf[Seq[AnyRef]] : _*)

  def condition(args : Any*) : Condition = 
    DSL.condition(string, args.asInstanceOf[Seq[AnyRef]] : _*)

  def table(args : Any*) : Table[Record] = 
    DSL.table(string, args.asInstanceOf[Seq[AnyRef]] : _*)

  def query(args : Any*) : Query = 
    DSL.query(string, args.asInstanceOf[Seq[AnyRef]] : _*)

  def resultQuery(args : Any*) : ResultQuery[Record] = 
    DSL.resultQuery(string, args.asInstanceOf[Seq[AnyRef]] : _*)

  private def string = {
    val pi = sc.parts.iterator
    val sb = new StringBuilder(pi.next())
    var i = 0;

    while (pi.hasNext) {
      sb += '{'
      sb ++= (i toString)
      sb += '}'
      sb ++= pi.next()

      i = i + 1;
    }

    sb.result
  }
}