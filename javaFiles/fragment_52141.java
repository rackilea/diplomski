Compiled from "Test.java"
public class Test extends java.lang.Object
  SourceFile: "Test.java"
  minor version: 0
  major version: 50
  Constant pool:
const #1 = Method   #4.#13; //  java/lang/Object."<init>":()V
const #2 = Field    #3.#14; //  Test.b:[B
const #3 = class    #15;    //  Test
const #4 = class    #16;    //  java/lang/Object
const #5 = Asciz    b;
const #6 = Asciz    [B;
const #7 = Asciz    <init>;
const #8 = Asciz    ()V;
const #9 = Asciz    Code;
const #10 = Asciz   LineNumberTable;
const #11 = Asciz   SourceFile;
const #12 = Asciz   Test.java;
const #13 = NameAndType #7:#8;//  "<init>":()V
const #14 = NameAndType #5:#6;//  b:[B
const #15 = Asciz   Test;
const #16 = Asciz   java/lang/Object;

{
byte[] b;

public Test();
  Code:
   Stack=5, Locals=1, Args_size=1
   0:   aload_0
   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
   4:   aload_0
   5:   iconst_5
   6:   newarray byte
   8:   dup
   9:   iconst_0
   10:  iconst_0
   11:  bastore
   12:  dup
   13:  iconst_1
   14:  iconst_1
   15:  bastore
   16:  dup
   17:  iconst_2
   18:  iconst_2
   19:  bastore
   20:  dup
   21:  iconst_3
   22:  iconst_3
   23:  bastore
   24:  dup
   25:  iconst_4
   26:  bipush  100
   28:  bastore
   29:  putfield    #2; //Field b:[B
   32:  return
  LineNumberTable: 
   line 1: 0
   line 2: 4


}