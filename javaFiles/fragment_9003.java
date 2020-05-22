$ java -version
java version "1.7.0"
Java(TM) SE Runtime Environment (build 1.7.0-b147)

$ javap -c -v Foo
Classfile /home/suboptimal/playground/Foo.class
  Last modified Jun 9, 2017; size 232 bytes
  MD5 checksum cfd57fb547ac98a1b2808549f5e9e8c1
public class Foo
  minor version: 0
  major version: 51 <-- class file Java 7
...

$ javac FooDemo.java
$ java FooDemo
Exception in thread "main" java.lang.VerifyError: Expecting a stackmap frame at branch target 9 in method Foo.bar(Ljava/lang/String;)Z at offset 4