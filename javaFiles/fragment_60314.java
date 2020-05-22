package de.scrum_master.stackoverflow

import groovy.transform.ToString
import groovy.transform.TupleConstructor
import spock.lang.Specification

class LambdaMethodRefTest extends Specification {

  def "Replace lambdas and method references in Groovy"() {
    given:
    def bookStream = [
      new Book("Fortran", "Fred", 1957, 57.99),
      new Book("Java in 3 Days", "Alice", 2005, 11.99),
      new Book("Java in 4 Days", "Bob", 2005, 22.99),
      new Book("Filter-Map-Reduce with Lambdas", "Claire", 2014, 33.99)
    ].stream()

    when:
    def mapReduceResult = bookStream
      .filter { it.year >= 2004 }
      .peek(System.out.&println)
      .map { it.author }
      .map { it.toUpperCase() }
      .peek { System.out.println(it) }
      .reduce("", { s1, s2 -> (s1.isEmpty()) ? s2 : s1 + ", " + s2 })

    then:
    mapReduceResult == "ALICE, BOB, CLAIRE"
  }

  @TupleConstructor
  @ToString(includeNames = true, includePackage = false)
  static class Book {
    String title, author; int year; double price
  }

}