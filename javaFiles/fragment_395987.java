C:\clojure>dir /b/s
C:\clojure\classes
C:\clojure\src
C:\clojure\src\test
C:\clojure\src\test\test.clj

C:\clojure>java -cp c:\dev\clojure.jar;.\src;.\classes clojure.lang.ReplClojure
user=> (compile 'test.test)
test.test
user=>