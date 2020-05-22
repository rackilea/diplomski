trait MyTrait[T]{
  type MyType = T
  implicit val MyTypeManifest: Manifest[T]
  val BoxOfMyType=new Def[Some[MyType]]
}

class X extends MyTrait[Int] {
  val MyTypeManifest = manifest[Int]
}