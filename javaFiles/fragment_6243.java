public enum Direction {
    North(South), South(North), East(West), West(East), Up(Down), Down(Up)
    Direction(Direction d){
        println "opposite of $this is $d"
    }
}

Direction.South // Force enum instantiation in GroovyConsole.