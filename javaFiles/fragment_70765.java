Some(2).fold
  {
    println("error")
  }
  {
    value =>
      println(s"Success: $value")
  }