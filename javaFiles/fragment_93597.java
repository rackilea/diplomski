package javascalainterop

import java.util.{Map => JMap}

class BComponent(inputMessage: String) extends IComponent {

  // Create an AComponent instance and access it as an IComponent.
  private final val aComponent: IComponent = new AComponent(inputMessage)

  // Implement overridden callme in terms of AComponent instance.
  override def callme(inputMap: JMap[String, AnyRef]): Unit = {
    println(s"Called BComponent.callme with $inputMessage")
    aComponent.callme(inputMap)
  }
}