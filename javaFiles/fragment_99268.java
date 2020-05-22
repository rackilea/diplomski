trait Element 
class MyElement extends Element
class MyOtherElement extends Element

import java.{ util => ju }
val myElements = new ju.ArrayList[MyElement]()
val elements: ju.List[_ <: Element] = myElements
elements.add(new MyOtherElement)
val myElement: MyElement = myElements.get(0)