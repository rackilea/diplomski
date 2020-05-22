package line3

object read {
    val a = Par.lazyUnit(42 + 1)
    val res3 = a
}

object eval {
    def print() = {
        println("a: Par.Par[Int] = " + read.res3)
    }
}