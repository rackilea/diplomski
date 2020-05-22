public static void main(java.lang.String[]);
   descriptor: ([Ljava/lang/String;)V
   flags: ACC_PUBLIC, ACC_STATIC
   Code:
     stack=2, locals=1, args_size=1
        0: getstatic     #16                 // Field java/lang/System.out:Ljav
/io/PrintStream;
        3: bipush        97                 // for single char. (pushed a byte as an int)
        5: invokevirtual #22                 // Method java/io/PrintStream.prin
ln:(C)V
        8: getstatic     #16                 // Field java/lang/System.out:Ljav
/io/PrintStream;
       11: sipush        195                // push sum of 2 chars as a short
       14: invokevirtual #28                 // Method java/io/PrintStream.prin
ln:(I)V
       17: return