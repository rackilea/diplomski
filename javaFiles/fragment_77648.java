use(groovy.time.TimeCategory) {
    def (y, w) = "2011-10".tokenize("-")
    w = ((w as int) + 1) as String
    def d = Date.parse("yyyy-w", "$y-$w") + 1.day
    println d.format("MMM dd")
}