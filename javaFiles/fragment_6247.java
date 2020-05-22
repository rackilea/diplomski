public enum Direction {
    North(1), South(0), East(3), West(2), Up(5), Down(4)
    private oppositeIndex
    Direction getOpposite() { 
        values()[oppositeIndex]
    }
    Direction(oppositeIndex) { 
        this.oppositeIndex = oppositeIndex
    }
}