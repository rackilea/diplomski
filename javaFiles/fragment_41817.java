package line5

object read {
    import line2.read.Par
    import line3.read.a
    import line4.read.es

    val res5 = Par.fork(a)(es).get
}

object eval {
    def print() = {
        println("res5: Int = " + read.res5)
    }
}