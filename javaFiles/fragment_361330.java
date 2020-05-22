val opt: Option[Product] = ???
opt match {
  // type-safe cast to type Some and deconstruction of the object (we get out the value
  // wich was originally passed to the Some constructor) :
  case Some(product) => print(s"Got you : $product")
  // type-safe cast to type None :
  case None => // do nothing
}