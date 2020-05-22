package main.scala

object traitsfun {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  sealed trait Calc {
    lazy val run: Int = 0 // val should have a default value
    def standardMethod(param:String) = println(s"Hello $param")
  }

  class Calc1 extends Calc {
    override lazy val run = 1
  }

  class Calc2 extends Calc {
    override lazy val run = 0
  }

  val c1 = (new Calc1).run                        //> c1  : Int = 1
  val c2 = (new Calc2).run                        //> c2  : Int = 0
  (new Calc1).standardMethod("Calc1")             //> "Hello Calc1"
}