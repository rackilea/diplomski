trait Worker[T <: Data]
{
   protected val data: ListBuffer[T] //Not var, and uninstantiated
   def loadXML: Unit = ???
   def getPath: String
}

object ConcreteWorkerA extends Worker[ConcreteDataA]
{
  override val data = new ListBuffer[ConcreteDataA] // Here the expected type differs
  override def getPath: String = "foo"
}