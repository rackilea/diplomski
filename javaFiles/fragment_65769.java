case class Part1(a: Int, b: Int, c: Int)
case class Part2(d: Int, e: Int, f: Int)
case class Aggregate(part1: Part1, part2: Part2)

val aggregate = Aggregate(Part1(0, 1, 2), Part2(3, 4, 5))

aggregate match {
    case Aggregate(Part1(a, b, c), Part2(d, e, f)) =>
}