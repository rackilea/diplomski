[dlee@dlee-mac scala]$ cat SomeClass.scala 
class SomeClass {
  def testIntTuple: (Int, Int) = (0, 1)
  def testIntegerTuple: (java.lang.Integer, java.lang.Integer) = (0, 1)
}

[dlee@dlee-mac scala]$ javap SomeClass
Compiled from "SomeClass.scala"
public class SomeClass implements scala.ScalaObject {
  public scala.Tuple2<java.lang.Object, java.lang.Object> testIntTuple();
  public scala.Tuple2<java.lang.Integer, java.lang.Integer> testIntegerTuple();
  public SomeClass();
}