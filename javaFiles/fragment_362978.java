Classfile /home/efrisch/workspace/StackOverflow/bin/com/stackoverflow/Main.class
  Last modified Jun 18, 2015; size 553 bytes
  MD5 checksum de4f987e783aa0f145e7245269504028
  Compiled from "Main.java"
class com.stackoverflow.Main
  minor version: 0
  major version: 52
  flags: ACC_SUPER
Constant pool:
   #1 = Class              #2             // com/stackoverflow/Main
   #2 = Utf8               com/stackoverflow/Main
   #3 = Class              #4             // java/lang/Object
   #4 = Utf8               java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Methodref          #3.#9          // java/lang/Object."<init>":()V
   #9 = NameAndType        #5:#6          // "<init>":()V
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               Lcom/stackoverflow/Main;
  #14 = Utf8               main
  #15 = Utf8               ([Ljava/lang/String;)V
  #16 = Fieldref           #17.#19        // java/lang/System.out:Ljava/io/PrintStream;
  #17 = Class              #18            // java/lang/System
  #18 = Utf8               java/lang/System
  #19 = NameAndType        #20:#21        // out:Ljava/io/PrintStream;
  #20 = Utf8               out
  #21 = Utf8               Ljava/io/PrintStream;
  #22 = String             #23            // Hello, World!
  #23 = Utf8               Hello, World!
  #24 = Methodref          #25.#27        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #25 = Class              #26            // java/io/PrintStream
  #26 = Utf8               java/io/PrintStream
  #27 = NameAndType        #28:#29        // println:(Ljava/lang/String;)V
  #28 = Utf8               println
  #29 = Utf8               (Ljava/lang/String;)V
  #30 = Utf8               args
  #31 = Utf8               [Ljava/lang/String;
  #32 = Utf8               SourceFile
  #33 = Utf8               Main.java
{
  com.stackoverflow.Main();
    descriptor: ()V
    flags:
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #8                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/stackoverflow/Main;

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #16                 // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #22                 // String Hello, World!
         5: invokevirtual #24                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 5: 0
        line 6: 8
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       9     0  args   [Ljava/lang/String;
}
SourceFile: "Main.java"