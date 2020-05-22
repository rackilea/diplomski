.version 51 0
.source MainClass.java
.class super public MainClass
.super java/lang/Object


.method public <init> : ()V
    ; method code size: 5 bytes
    .limit stack 1
    .limit locals 1
    aload_0
    invokespecial java/lang/Object <init> ()V
    return
.end method

.method static public main : ([Ljava/lang/String;)V
    ; method code size: 26 bytes
    .limit stack 2
    .limit locals 4
    ldc 'abc'
    astore_1
    ldc 'def'
    astore_2
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder <init> ()V
    aload_1
    invokevirtual java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload_2
    invokevirtual java/lang/StringBuilder append (Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder toString ()Ljava/lang/String;
    astore_3
    return
.end method