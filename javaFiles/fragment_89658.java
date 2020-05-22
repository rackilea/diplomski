.class public Testing
.super java/lang/Object
.implements InterfaceA
.implements InterfaceB

.method public static getStuff()I
  ldc 666
  ireturn
.end method

.method public static getStuff()Ljava/lang/String;
  ldc "Evil stuff"
  areturn
.end method

.method public static main([Ljava/lang/String;)V
  .limit stack 10
  getstatic java/lang/System/out Ljava/io/PrintStream;
  dup
  invokestatic Testing/getStuff()I
  invokevirtual java/io/PrintStream/println(I)V
  invokestatic Testing/getStuff()Ljava/lang/String;
  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
  return
.end method