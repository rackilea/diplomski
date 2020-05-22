private val val sdf = SimpleDateFormat("MMM yyyy")

fun compare(s1: String?, s2: String?): Int = when {
  s1 == s2 -> 0
  s1 == "MAT TY" -> -1
  s2 == "MAT TY" -> 1
  s1 == "MAT YA" -> -1
  s2 == "MAT YA" -> 1
  s1 == null -> 1
  s2 == null -> -1
  else -> sdf.parse(s1).compareTo(sdf.parse(s2))
}