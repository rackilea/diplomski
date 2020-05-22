Map{
  "a" -> 2 // weight 2
  "b" -> 2
  "c" -> 2
  "d" -> 1
  "e" -> 1
  "f" -> 1
}
=>
Map{
  "a" -> (0,2) // weight 2 -- is now length of the interval
  "b" -> (2,4) // ...
  "c" -> (4,6)
  "d" -> (6,7)
  "e" -> (7,8)
  "f" -> (8,9)
}