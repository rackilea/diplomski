$ javap -c -v Foo
public class Foo extends java.lang.Object
  minor version: 0
  major version: 50
...
public static boolean bar(java.lang.String);
  Code:
   Stack=1, Locals=1, Args_size=1
   0:   aload_0
   1:   invokevirtual   #16; //Method java/lang/String.length:()I
   4:   ifne    9
   7:   iconst_1
   8:   ireturn
   9:   iconst_0
   10:  ireturn
}