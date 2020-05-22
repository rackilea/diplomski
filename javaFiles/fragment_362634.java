struct P {
        let x, y: Double
        init() {
            x = (Double(arc4random()) / 0xFFFFFFFF) * 2 - 1
            y = sqrt(1 - x * x) * (arc4random() % 2 == 0 ? 1 : -1)
        }
        func dist(other: P) -> Double {
            return sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y))
        }
    }
    let root3 = sqrt(3.0)
    let total = 100_000_000
    var samples = 0
    for var i = 0; i < total; i++ {
        if P().dist(P()) > root3 {
            samples++
        }
    }
    println(Double(samples) / Double(total))