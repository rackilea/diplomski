val r = scala.util.Random

val pks = List("1289359", "345623p")

val hashes = pks.map { pk =>
  r.setSeed(pk.hashCode())
  (pk, r.nextDouble())
}