scala> class Foo(actor: Actor) {
     | println(actor.toString)
     | }
defined class Foo

scala> new Foo(_: Actor)
res0: (scala.actors.Actor) => Foo = <function1>