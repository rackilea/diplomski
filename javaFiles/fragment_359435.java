for(Object o : list) {
}

  44: aload_1
  45: invokevirtual #30                 // Method java/util/LinkedList.iterator:()Ljava/util/Iterator;
  48: astore_3
  49: goto          59
  52: aload_3
  53: invokeinterface #34,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
  58: astore_2
  59: aload_3
  60: invokeinterface #40,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
  65: ifne          52