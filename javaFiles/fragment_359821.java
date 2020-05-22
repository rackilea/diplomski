val hashes = for {
  i <- 0 to 4
  j <- 0 to 4
} yield (i * 31 + j) % 38

println(hashes.size) // prints 25
println(hashes.toSet.size) // prints 25