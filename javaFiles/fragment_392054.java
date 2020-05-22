class Registry {
    private val registry = mutable.HashMap.empty[Class[_ <: IType], Class[_ <: IParser]]

    def getParser(cl: Class[_ <: IType]) = {
      registry(cl).newInstance()
    }

    def getParserT[T <: IType : ClassTag]: IParser = 
      getParser(classTag[T].runtimeClass.asSubclass(classOf[IType]))
  }