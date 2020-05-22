Classfile /home/mernst/GroupPayload.class
  Last modified Jan 16, 2020; size 515 bytes
  MD5 checksum 3db07417a8da20b35032650b64e9ffce
  Compiled from "GroupPayload.java"
public class GroupPayload<T extends java.lang.Object> extends java.lang.Object
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #3.#22         // java/lang/Object."<init>":()V
   #2 = Class              #23            // GroupPayload
   #3 = Class              #24            // java/lang/Object
   #4 = Utf8               data
   #5 = Utf8               Ljava/util/List;
   #6 = Utf8               Signature
   #7 = Utf8               Ljava/util/List<TT;>;
   #8 = Utf8               RuntimeInvisibleTypeAnnotations
   #9 = Utf8               LValid;
  #10 = Utf8               <init>
  #11 = Utf8               ()V
  #12 = Utf8               Code
  #13 = Utf8               LineNumberTable
  #14 = Utf8               LocalVariableTable
  #15 = Utf8               this
  #16 = Utf8               LGroupPayload;
  #17 = Utf8               LocalVariableTypeTable
  #18 = Utf8               LGroupPayload<TT;>;
  #19 = Utf8               <T:Ljava/lang/Object;>Ljava/lang/Object;
  #20 = Utf8               SourceFile
  #21 = Utf8               GroupPayload.java
  #22 = NameAndType        #10:#11        // "<init>":()V
  #23 = Utf8               GroupPayload
  #24 = Utf8               java/lang/Object
{
  java.util.List<T> data;
    descriptor: Ljava/util/List;
    flags:
    Signature: #7                           // Ljava/util/List<TT;>;
    RuntimeInvisibleTypeAnnotations:
      0: #9(): FIELD, location=[TYPE_ARGUMENT(0)]

  public GroupPayload();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 8: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LGroupPayload;
      LocalVariableTypeTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   LGroupPayload<TT;>;
}
Signature: #19                          // <T:Ljava/lang/Object;>Ljava/lang/Object;
SourceFile: "GroupPayload.java"