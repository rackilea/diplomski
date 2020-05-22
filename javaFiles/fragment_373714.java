class MyClass {

def myMethod(x: Array[java.lang.Double]): Double = {
    val methodValue = for(i <- x.indices) yield { math.pow( x(i),2.0) }
    methodValue.sum
    }

}