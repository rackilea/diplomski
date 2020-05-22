class IterationForCoin(stream: Stream[Int], coin: Int) {
  val (lower, higher) = stream splitAt coin
  val next: Stream[Int] = lower #::: (higher zip next map { case (a, b) => a + b })
}
val coins = List(1, 2, 5, 10, 20, 50, 100, 200)
val result = coins.foldLeft(1 #:: Stream.fill(200)(0)) { (stream, coin) =>
  new IterationForCoin(stream, coin).next
} last