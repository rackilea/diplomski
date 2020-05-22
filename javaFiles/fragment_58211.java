public class hello {
     public String sayHi() {
         return "hello world";
     }
 }

$ javac hello.java
$ java -cp clojure.jar:./ clojure.main
user=> (import 'hello) ;; Necessary in 1.2.1, but not 1.3.0
user=> (.sayHi (hello.))
"hello world"