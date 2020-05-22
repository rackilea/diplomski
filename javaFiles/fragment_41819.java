object read {
    import line2.read.Par
    import line3.read.a
    import line4.read.es

    def aWrapper():Int = a

    val res5 = Par.fork(aWrapper _)(es).get
}