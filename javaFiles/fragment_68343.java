public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String 2
       2: astore_2      
       3: iconst_m1     
       4: istore_3      
       5: aload_2       
       6: invokevirtual #3                  // Method java/lang/String.hashCode:()I
       9: tableswitch   { // 49 to 51
                    49: 36
                    50: 50
                    51: 64
               default: 75
          }
      36: aload_2       
      37: ldc           #4                  // String 1
      39: invokevirtual #5                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      42: ifeq          75
      45: iconst_0      
      46: istore_3      
      47: goto          75
      50: aload_2       
      51: ldc           #2                  // String 2
      53: invokevirtual #5                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      56: ifeq          75
      59: iconst_1      
      60: istore_3      
      61: goto          75
      64: aload_2       
      65: ldc           #6                  // String 3
      67: invokevirtual #5                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
      70: ifeq          75
      73: iconst_2      
      74: istore_3      
      75: iload_3       
      76: tableswitch   { // 0 to 2
                     0: 104
                     1: 115
                     2: 126
               default: 137
          }
     104: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     107: ldc           #8                  // String Happy
     109: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     112: goto          145
     115: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     118: ldc           #10                 // String Birthday
     120: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     123: goto          145
     126: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     129: ldc           #11                 // String To the ground!
     131: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     134: goto          145
     137: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     140: ldc           #12                 // String <3
     142: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     145: return