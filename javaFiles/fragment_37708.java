import java.util.regex.{MatchResult, Pattern}

class GroupNamedRegex(pattern: Pattern, namedGroups: Set[String]) {
  def this(regex: String) = this(Pattern.compile(regex), 
    "\\(\\?<([a-zA-Z][a-zA-Z0-9]*)>".r.findAllMatchIn(regex).map(_.group(1)).toSet)

  def findNamedMatches(s: String): Iterator[GroupNamedRegex.Match] = new Iterator[GroupNamedRegex.Match] {
    private[this] val m = pattern.matcher(s)
    private[this] var _hasNext = m.find()

    override def hasNext = _hasNext

    override def next() = {
      val ans = GroupNamedRegex.Match(m.toMatchResult, namedGroups.find(group => m.group(group) != null))
      _hasNext = m.find()
      ans
    }
  }
}

object GroupNamedRegex extends App {
  case class Match(result: MatchResult, groupName: Option[String])

  val r = new GroupNamedRegex("(?<FB>(FACE(\\p{Space}?)BOOK))|(?<GOOGL>(GOOGL(E)?))")
  println(r.findNamedMatches("FACEBOOK is buying GOOGLE and FACE BOOK FB").map(s => s.groupName -> s.result.group()).toList)
}