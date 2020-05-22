func makeIncrementer(forIncrement amount: Int) -> () -> Int {
    var runningTotal = 0
    return () -> Int {
        runningTotal += amount
        return runningTotal
    }
}