use(groovy.time.TimeCategory) {
    def today = new Date()
    println today
    12.times { i ->
        println today - (i+1).months
    }
}