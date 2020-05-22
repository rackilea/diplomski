dateNums = [
    [1, 10, 2011],
    [1, 9, 2011],
    // etc.
]
dates = []

dateNums.each {
    d = new Date(it[2]-1900, it[1]-1, it[0])
    println d
    dates.add(d)
}