; Entry point for the jar
.class Main
.super java/lang/Object

.method public static main : ([Ljava/lang/String;)V
    .limit stack 10
    .limit locals 10
    invokestatic int                                hello ()V
    invokestatic "-42"                              hello ()V
    invokestatic ""                                 hello ()V
    invokestatic "  some  whitespace and \t tabs"   hello ()V
    invokestatic "new\nline"                        hello ()V
    invokestatic 'name with "Quotes" in it'         hello ()V
    return
.end method
.end class


.class int
.super java/lang/Object
.method public static hello : ()V
    .limit stack 2
    .limit locals 0
    getstatic java/lang/System out Ljava/io/PrintStream;
    ldc "Hello from int"
    invokevirtual java/io/PrintStream println (Ljava/lang/Object;)V
    return
.end method
.end class

.class "-42"
.super java/lang/Object
.method public static hello : ()V
    .limit stack 2
    .limit locals 0
    getstatic java/lang/System out Ljava/io/PrintStream;
    ldc "Hello from -42"
    invokevirtual java/io/PrintStream println (Ljava/lang/Object;)V
    return
.end method
.end class

; Even the empty string can be a class name!
.class ""
.super java/lang/Object
.method public static hello : ()V
    .limit stack 2
    .limit locals 0
    getstatic java/lang/System out Ljava/io/PrintStream;
    ldc "Hello from "
    invokevirtual java/io/PrintStream println (Ljava/lang/Object;)V
    return
.end method
.end class

.class "  some  whitespace and \t tabs"
.super java/lang/Object
.method public static hello : ()V
    .limit stack 2
    .limit locals 0
    getstatic java/lang/System out Ljava/io/PrintStream;
    ldc "Hello from   some  whitespace and \t tabs"
    invokevirtual java/io/PrintStream println (Ljava/lang/Object;)V
    return
.end method
.end class

.class "new\nline"
.super java/lang/Object
.method public static hello : ()V
    .limit stack 2
    .limit locals 0
    getstatic java/lang/System out Ljava/io/PrintStream;
    ldc "Hello from new\nline"
    invokevirtual java/io/PrintStream println (Ljava/lang/Object;)V
    return
.end method
.end class

.class 'name with "Quotes" in it'
.super java/lang/Object
.method public static hello : ()V
    .limit stack 2
    .limit locals 0
    getstatic java/lang/System out Ljava/io/PrintStream;
    ldc "Hello from name with \"Quotes\" in it"
    invokevirtual java/io/PrintStream println (Ljava/lang/Object;)V
    return
.end method
.end class