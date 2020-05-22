package de.scrum_master.stackoverflow.q56652868

import de.scrum_master.stackoverflow.q56652868.A.B
import de.scrum_master.stackoverflow.q56652868.A.C
import de.scrum_master.stackoverflow.q56652868.A.D
import de.scrum_master.stackoverflow.q56652868.A.E
import spock.lang.Specification

class ATest extends Specification {
  def "test when doSth"() {
    given: 'A class'
    A aClass = Spy(constructorArgs: [Mock(B), Mock(C), Mock(D), Mock(E)])

    when:
    aClass.doSth()

    then:
    1 * aClass.test()
  }
}