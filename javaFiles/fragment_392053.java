import scala.collection.mutable

  trait IType

  trait IParser {
    def parse(msg: Array[Byte]): IType
  }

  class Registry {
    private val registry = mutable.HashMap.empty[Class[T] forSome {type T <: IType}, Class[Z] forSome {type Z <: IParser}]

    def getParser(cl: Class[T] forSome {type T <: IType}) = {
      registry(cl).newInstance()
    }
  }