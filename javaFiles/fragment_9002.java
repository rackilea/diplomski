$ java -version
java version "1.7.0"
Java(TM) SE Runtime Environment (build 1.7.0-b147)

$ javap -c -v Foo
Classfile /home/suboptimal/playground/Foo.class
  Last modified Jun 9, 2017; size 232 bytes
  MD5 checksum 5a7ea4a5dd2f6d1bcfddb9ffd720f9c9
public class Foo
  minor version: 0
  major version: 50 <-- class file Java 6
...

$ javac FooDemo.java
$ java FooDemo
output: true