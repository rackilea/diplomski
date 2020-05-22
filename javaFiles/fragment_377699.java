$ javac package-info.java 
$ ls -l
total 8
-rw-rw-r-- 1 peter peter 180 2012-03-21 12:08 package-info.class
-rw-rw-r-- 1 peter peter  87 2012-03-21 12:08 package-info.java

$ javap -c -v -classpath .. mypackage.package-info
Classfile /d/peter/untitled/src/main/java/mypackage/package-info.class
  Last modified 21-Mar-2012; size 180 bytes
  MD5 checksum f152dc2e8a45929ef297f6ac05a4067e
  Compiled from "package-info.java"
interface mypackage.package-info
  SourceFile: "package-info.java"
  RuntimeVisibleAnnotations:
    0: #6()
  minor version: 0
  major version: 51
  flags: ACC_INTERFACE, ACC_ABSTRACT, ACC_SYNTHETIC
Constant pool:
  #1 = Class              #7              //  "mypackage/package-info"
  #2 = Class              #8              //  java/lang/Object
  #3 = Utf8               SourceFile
  #4 = Utf8               package-info.java
  #5 = Utf8               RuntimeVisibleAnnotations
  #6 = Utf8               Ljava/lang/Deprecated;
  #7 = Utf8               mypackage/package-info
  #8 = Utf8               java/lang/Object
{
}