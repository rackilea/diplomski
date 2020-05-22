val xs = List(1,2,3,4,5,6)
xs match {
  case h :: t =>
    // h is the head: 1
    // t is the tail: 2,3,4,5,6
    // The :: above is also an example of matching with an INFIX TYPE
}