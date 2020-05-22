class Dog {
  def eat(food: Food) = Dog.preferredFoods.contains(food)
}

object Dog {
  private val preferredFoods = List(Ribeye, DogFood, Banana)
  def walk(dog: Dog) = ???
}