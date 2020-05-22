case class Person(name: String, age: Int)
val p = Person("John Doe", 42)
p match {
  case Person(name, 42) =>
    //only extracting the name here, the match would fail if the age wasn't 42
    println(name)
}