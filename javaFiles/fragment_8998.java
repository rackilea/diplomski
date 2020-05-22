public class Foo {
    public static boolean bar(String s) {
        if (s.length() == 0) {
            return true;
        }
        return false;
    }
}

$ java -version
java version "1.6.0"
Java(TM) SE Runtime Environment (build 1.6.0-b105)
$ javac Foo.java
$ javap -c -v Foo
Compiled from "Foo.java"
public class Foo extends java.lang.Object
  SourceFile: "Foo.java"
  minor version: 0
  major version: 50
...
public static boolean bar(java.lang.String);
  Code:
   Stack=1, Locals=1, Args_size=1
   0:   aload_0
   1:   invokevirtual   #2; //Method java/lang/String.length:()I
   4:   ifne    9
   7:   iconst_1
   8:   ireturn
   9:   iconst_0
   10:  ireturn
  LineNumberTable: 
   line 3: 0
   line 4: 7
   line 6: 9

  StackMapTable: number_of_entries = 1
   frame_type = 9 /* same */
}