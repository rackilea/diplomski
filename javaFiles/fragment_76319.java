# cat Athrow.j 
.source Athrow.j
.class public Athrow
.super java/lang/Object

.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 2

    new java/lang/Object
    dup
    invokenonvirtual java/lang/Object/<init>()V
    athrow

    return
.end method

# java -jar jasmin.jar Athrow.j 
Generated: Athrow.class

# java Athrow
Exception in thread "main" java.lang.VerifyError: (class: Athrow, method: main signature: ([Ljava/lang/String;)V) Can only throw Throwable objects