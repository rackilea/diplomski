$ java -version
java version "1.8.0"
Java(TM) SE Runtime Environment (build 1.8.0-b132)

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
Exception in thread "main" java.lang.VerifyError: Expecting a stackmap frame at branch target 9

$ java -XX:-UseSplitVerifier FooDemo
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option UseSplitVerifier; support was removed in 8.0
Exception in thread "main" java.lang.VerifyError: Expecting a stackmap frame at branch target 9