for (word <- List(
  "european", "anounce", "anounc",
  "EUROPEAN", "Anounce", "AnOUnc")
) {
  val pieces = word.split("(?i)(?<=[aeiou])(?=[^aeiou].*[aeiou])")
  println("    " + word + " -> " + pieces.mkString("[", ",", "]"))
}