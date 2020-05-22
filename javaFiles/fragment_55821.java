package de.scrum_master.stackoverflow.q60103582

import spock.lang.Specification

class MyClassTest extends Specification {
  def "check main business logic"(){
    given:
    Object1 obj1 = Mock()
    Object2 obj2 = Mock()
    Object3 obj3 = Mock()

    MyClass myClass = Spy(constructorArgs: [obj1, obj2, obj3])

    when:
    myClass.process(new Object4())

    then:
    1 * myClass.getScore(_) //>> obj2
    1 * myClass.computeScore(_) //>> obj3
  }
}