fun accumulate(list: List<Double>): List<Double> {
    var runningSum = 0.0
    return list.map {
        runningSum += it
        runningSum
    }
}