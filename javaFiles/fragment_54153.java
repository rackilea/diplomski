Code:
   0:   ldc #2; //String ab
   2:   astore_0
   3:   ldc #2; //String ab
   5:   astore_3
   6:   ldc #3; //String a
   8:   astore  4
   10:  ldc #4; //String b
   12:  astore  5
   14:  ldc #2; //String ab
   16:  astore  6
   18:  new #5; //class java/lang/StringBuilder
   21:  dup
   22:  invokespecial   #6; //Method java/lang/StringBuilder."<init>":()V
   25:  aload   4
   27:  invokevirtual   #7; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   30:  aload   5
   32:  invokevirtual   #7; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
   35:  invokevirtual   #8; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
   38:  astore  7
   40:  return