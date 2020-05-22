enum Direction {
    North, South, East, West, Up, Down
    private Direction opposite
    Direction getOpposite() { opposite }

    static {
        def opposites = { d1, d2 -> d1.opposite = d2; d2.opposite = d1 }
        opposites(North, South)
        opposites(East, West)
        opposites(Up, Down)
    }
}

Direction.values().each { 
    println "opposite of $it is $it.opposite"
}