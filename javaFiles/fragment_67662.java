object FormulaParser extends StandardTokenParsers with PackratParsers {
  //Symbols for all connectives
  private val parseSymbols = List("(", ")", "+", "-", "!", "&", "|", ">", "<")
  lexical.delimiters ++= parseSymbols

  private lazy val formula: PackratParser[Formula] = implication | equivalence | conjunction | disjunction | term
  private lazy val formulaWithoutBrackets: PackratParser[Formula] = implication | equivalence | conjunction | disjunction | termWithoutBrackets

  private lazy val term: PackratParser[Formula] = top | bottom | variable | parens | negation
  private lazy val termWithoutBrackets = top | bottom | variable | negation

  private lazy val top: PackratParser[Formula] = "+" ^^^ { Top() }
  private lazy val bottom: PackratParser[Formula] = "-" ^^^ { Bottom() }
  private lazy val variable: PackratParser[Formula] = ident ^^ { Variable(_) }
  private lazy val parens: PackratParser[Formula] = "(" ~> formulaWithoutBrackets <~ ")"
  private lazy val negation: PackratParser[Formula] = "!" ~> term ^^ { Negation(_) }

  private lazy val conjunction: PackratParser[Formula] = term ~ "&" ~ term ~ rep("&" ~> term) ^^ {
    case p ~ "&" ~ q ~ conj => conj.foldLeft(Conjunction(p,q))((con, elem) => Conjunction(con, elem))
  }

  private lazy val disjunction: PackratParser[Formula] = term ~ "|" ~ term ~ rep("|" ~> term) ^^ {
    case p ~ "|" ~ q ~ disj => disj.foldLeft(Disjunction(p,q))((dis, elem) => Disjunction(dis, elem))
  }

  private lazy val implication: PackratParser[Formula] = (conjunction | disjunction | term) ~ ">" ~ (conjunction | disjunction | term) ^^ { case p ~ ">" ~ q => Implication(p, q) }

  private lazy val equivalence: PackratParser[Formula] = (conjunction | disjunction | term) ~ "<" ~ (conjunction | disjunction | term) ^^ { case p ~ "<" ~ q => Equivalence(p, q) }
}