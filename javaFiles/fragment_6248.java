enum Direction {
    North, South, East, West, Up, Down
    Direction getOpposite() { 
        values()[ordinal() + ordinal() % 2 * -2 + 1]
    }
}