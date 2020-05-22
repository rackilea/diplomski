L11
    LINENUMBER 13 L11
    NEW java/io/PrintWriter
    DUP
    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
    INVOKESPECIAL java/io/PrintWriter.<init> (Ljava/io/OutputStream;)V
    ASTORE 1
   L12
    ACONST_NULL
    ASTORE 2
   L3
    LINENUMBER 14 L3
    ALOAD 1
    LDC "Hello World"
    INVOKEVIRTUAL java/io/PrintWriter.println (Ljava/lang/String;)V
   L4
    LINENUMBER 15 L4
    ALOAD 1
    IFNULL L13
    ALOAD 2
    IFNULL L14
   L0
    ALOAD 1
    INVOKEVIRTUAL java/io/PrintWriter.close ()V
   L1
    GOTO L13
   L2