object BigInt {
  import java.math.BigInteger

  private val toBigInteger: (Array[Int], Int) => BigInteger = try {
    val ctor = classOf[BigInteger].getDeclaredConstructor(
      classOf[Array[Int]], classOf[Int]
    )
    ctor.setAccessible(true)

    (arr, signum) => ctor.newInstance(arr, signum.asInstanceOf[Object])
  } catch { case _: NoSuchMethodException =>
    (arr, signum) =>
      val buffer = java.nio.ByteBuffer.allocate(arr.length * 4)
      buffer.asIntBuffer.put(arr)
      new BigInteger(signum, buffer.array)
  }
}

final class BigInt(final val signum: Int, final val arr: Array[Int]) {
  def bigInteger = BigInt.toBigInteger(arr, signum)
}