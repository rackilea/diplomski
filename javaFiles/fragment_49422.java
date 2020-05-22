fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var runningSum = 0.0
    list.indices.forEach { i ->
        runningSum += list[i]
        list[i] = runningSum
    }
    return list
}