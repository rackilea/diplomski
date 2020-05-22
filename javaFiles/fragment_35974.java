trait Dog {
  def makeSound(): Unit = println("Woof")
  def beHappy(): Unit = println("Wag tail")
}

trait Cat {
  def makeSound(): Unit = println("Meow")
  def beHappy(): Unit = println("Purrr")
}

class PurringDog extends Dog with Cat {
  override def makeSound() = super[Dog].makeSound()
  override def beHappy() = super[Cat].beHappy()
}

object Test extends App {
  val purringDog = new PurringDog
  purringDog.beHappy()
  purringDog.makeSound()
}