abstract class Animal {}

case class Dog() extends Animal
case class Cat() extends Animal 

object Animal {

  def printAnimal(a : Animal) = a match {
    case x : Dog => "Dog"
    case x : Cat => "Cat"
    case _ => "Unknown"
  }
  def main(args : Array[String]) = {
    println(printAnimal(Dog()))
  }
}