fun BigInteger.plus(other: BigInteger): BigInteger = this.add(other)
fun BigInteger.minus(other: BigInteger): BigInteger = this.subtract(other)

object Binomial {
    val map = mutableMapOf<Pair<BigInteger, BigInteger>, BigInteger>()

    fun binomial(n: Int, k: Int): BigInteger =
        binomial(Pair(n.toBigInteger(), k.toBigInteger()))


    fun binomial(x: Pair<BigInteger, BigInteger>): BigInteger {
        val (n, k) = x
        if (k == ZERO || n == k) {
            return ONE
        }
        return map.getOrPut(x) { binomial(Pair(n - ONE, k)) + binomial(Pair(n - ONE, k - ONE)) }
    }
}

fun main() {
    println(binomial(8, 4)) // 70
}