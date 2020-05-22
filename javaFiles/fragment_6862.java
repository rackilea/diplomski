Compiled from "Application.java"
public class Application extends java.lang.Object{
public Application();
  Code:
   0:   aload_0
   1:   invokespecial   #8; //Method java/lang/Object."<init>":()V
   4:   return

public static void main(java.lang.String[]);
  Code:
   0:   ldc #16; //String Scrum
   2:   astore_1
   3:   aload_1
   4:   ldc #18; //String \p{Alpha}{3}
   6:   invokevirtual   #20; //Method java/lang/String.matches:(Ljava/lang/String;)Z
   9:   istore_2
   10:  iload_2
   11:  ldc #26; //String Foo must have exactly 3 characters!
   13:  invokestatic    #28; //Method checkArgument:(ZLjava/lang/String;)V
   16:  aload_1
   17:  ldc #18; //String \p{Alpha}{3}
   19:  invokevirtual   #20; //Method java/lang/String.matches:(Ljava/lang/String;)Z
   22:  ldc #26; //String Foo must have exactly 3 characters!
   24:  invokestatic    #28; //Method checkArgument:(ZLjava/lang/String;)V
   27:  return

}