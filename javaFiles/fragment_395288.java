package com.stackoverflow

import org.scalatest.FlatSpec

/**
 * @author maba, 2012-11-14
 */
class HelloJavaTest extends FlatSpec {
  "HelloJava" should "be instance of Hello" in {
    val hello = new HelloJava
    val result = hello match {
      case f:Hello => true
    }
    assert(result)
  }

  it should "say Hello Java" in {
    val helloJava = new HelloJava
    assert(helloJava.hello === "Hello Java")
  }
}