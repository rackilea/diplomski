public static void main(java.lang.String[]);
    Code:
       // s1 = "My Computer"
       0: ldc           #2                  // String My Computer
       2: astore_1

       // s2 = "My" + " Computer"
       3: ldc           #2                  // String My Computer
       5: astore_2

       // s3 = "My"
       6: ldc           #3                  // String My
       8: astore_3

       // s4 = s3 + " Computer"
       9: new           #4                  // class java/lang/StringBuilder
      12: dup
      13: invokespecial #5                  // Method java/lang/StringBuilder."<
init>":()V
      16: aload_3
      17: invokevirtual #6                  // Method java/lang/StringBuilder.ap
pend:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      20: ldc           #7                  // String  Computer
      22: invokevirtual #6                  // Method java/lang/StringBuilder.ap
pend:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      25: invokevirtual #8                  // Method java/lang/StringBuilder.to
String:()Ljava/lang/String;
      28: astore        4

      ... the rest of the code omitted