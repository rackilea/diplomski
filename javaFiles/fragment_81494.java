43: invokevirtual #9                  // Method com/company/HelloWorld$History.iterator:()Ljava/util/ListIterator;
  46: astore_2
  47: aload_2
  48: invokeinterface #10,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
  53: ifeq          101
  56: aload_2
  57: invokeinterface #11,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
  62: checkcast     #12                 // class java/lang/Integer
  65: astore_3
  66: getstatic     #13                 // Field java/lang/System.out:Ljava/io/PrintStream;
  69: aload_3
  70: invokevirtual #14                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
  73: aload_3
  74: invokevirtual #15                 // Method java/lang/Integer.intValue:()I
  77: iconst_3
  78: irem
  79: iconst_1
  80: if_icmpne     98
  83: getstatic     #13                 // Field java/lang/System.out:Ljava/io/PrintStream;
  86: aload_1
  87: invokevirtual #9                  // Method com/company/HelloWorld$History.iterator:()Ljava/util/ListIterator;
  90: invokeinterface #16,  1           // InterfaceMethod java/util/ListIterator.previous:()Ljava/lang/Object;
  95: invokevirtual #14                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V