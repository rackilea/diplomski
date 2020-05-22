object FooBar {
  class Foo {
    def createToken(id: String): String = ???
    def getItems(id: String): List[FooItem] = ???
  }
  class Bar {
    def createToken(id: String): String = ???
    def getItems(id: String): List[BarItem] = ???
  }

  class FooItem
  class BarItem

  implicit object FooTokenable extends Tokenable[Foo, FooItem] {
    def createToken(f: Foo, id: String) = f.createToken(id)
    def getItems(f: Foo, id: String) = f.getItems(id)
  }

  implicit object BarTokenable extends Tokenable[Bar, BarItem] {
    def createToken(b: Bar, id: String) = b.createToken(id)
    def getItems(b: Bar, id: String) = b.getItems(id)
  }
}