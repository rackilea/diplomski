package de.scrum_master.stackoverflow

import spock.lang.Specification

class MyConverterTest extends Specification {
  def "test"() {
    given:
    def myConverter = Mock(MyConverter) {
      convert(_) >>> ["one", "two"] >> { callRealMethod() }
    }

    expect:
    myConverter.convert(11) == "one"
    myConverter.convert(22) == "two"
    myConverter.convert(11) == "11"
    myConverter.convert(22) == "22"
  }
}