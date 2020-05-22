int compare();
         ....
         0: aload_0
         1: getfield      #7                  // Field item1:LA;
         4: checkcast     #13                 // class java/lang/Comparable
         7: aload_0
         8: getfield      #15                 // Field item2:LA;
        11: invokeinterface #18,  2           // InterfaceMethod java/lang/Comparable.compareTo:(Ljava/lang/Object;)I
        16: ireturn
        ....