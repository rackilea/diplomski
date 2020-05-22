public void doSomething(java.lang.String, java.lang.String);
Code:
   0: new           #2  // class StringBuilder
   3: dup           
   4: invokespecial #3  // Method StringBuilder."<init>":()V
   7: aload_1       
   8: invokevirtual #4  // Method StringBuilder.append:(LString;)LStringBuilder;
  11: ldc           #5  // String a
  13: invokevirtual #4  // Method StringBuilder.append:(LString;)LStringBuilder;
  16: invokevirtual #6  // Method StringBuilder.toString:()LString;
  19: astore_3      
  20: new           #2  // class StringBuilder
  23: dup           
  24: invokespecial #3  // Method StringBuilder."<init>":()V
  27: aload_2       
  28: invokevirtual #4  // Method StringBuilder.append:(LString;)LStringBuilder;
  31: ldc           #7  // String b
  33: invokevirtual #4  // Method StringBuilder.append:(LString;)LStringBuilder;
  36: invokevirtual #6  // Method StringBuilder.toString:()LString;
  39: astore        4
  41: new           #2  // class StringBuilder
  44: dup           
  45: invokespecial #3  // Method StringBuilder."<init>":()V
  48: aload_3       
  49: invokevirtual #4  // Method StringBuilder.append:(LString;)LStringBuilder;
  52: aload         4
  54: invokevirtual #4  // Method StringBuilder.append:(LString;)LStringBuilder;
  57: invokevirtual #6  // Method StringBuilder.toString:()LString;
  60: astore        5
  62: aload         5
  64: astore        6
  66: getstatic     #8  // Field System.out:Ljava/io/PrintStream;
  69: aload         6
  71: invokevirtual #9  // Method java/io/PrintStream.println:(LString;)V
  74: return