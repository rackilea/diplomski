package javascalainterop

import java.util.{HashMap => JHashMap}

object ComponentUser extends App {
  //val bComponent = new BComponent("testmessage")
  val javaMap = new JHashMap[String, AnyRef]
  //bComponent.callme(javaMap)

  // Test what happens when calling callme through each reference.
  val aComponent = new AComponent("AComponent")
  val iComponent: IComponent = aComponent
  iComponent.callme(javaMap)
  aComponent.callme(javaMap)
}