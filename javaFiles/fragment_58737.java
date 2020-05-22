trait EarlyInit {
  val mirror = runtimeMirror(this.getClass.getClassLoader)
  val reflection  = mirror.reflect(this)

  mirror
    .classSymbol(this.getClass)
    .toType
    .members
    .sorted    /// This method is documented to return members "in declaration order"
    .filter(_.isModule)
    .foreach(m => reflection.reflectModule(m.asModule).instance)
  }
}