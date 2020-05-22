$ java -jar org.eclipse.jdt.core-3.10.0.v20140604-1726.jar -source 1.8 LambdaTest.java 
$ java LambdaTest
Works fine with an object
Calling consume
Hello
Calling accept with context
Hello
Calling accept via consumer...
Exception in thread "main" java.lang.AbstractMethodError: Method LambdaTest$$Lambda$1.accept(Ljava/lang/Object;)V is abstract
    at LambdaTest$$Lambda$1/424058530.accept(Unknown Source)
    at LambdaTest.main(LambdaTest.java:24)