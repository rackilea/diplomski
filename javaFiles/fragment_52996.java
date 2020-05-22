10: iload_2
11: iinc          2, -1
14: ifle          40
17: new           #7                  // class java/lang/StringBuilder
20: dup
21: invokespecial #8                  // Method java/lang/StringBuilder."<init>":()V
24: aload_1
25: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
28: ldc           #16                 // String
30: invokevirtual #10                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
33: invokevirtual #17                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
36: astore_1
37: goto          10