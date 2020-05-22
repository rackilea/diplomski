INVOKEINTERFACE java/util/List.iterator ()Ljava/util/Iterator;
ASTORE 2
L2
ALOAD 2
INVOKEINTERFACE java/util/Iterator.hasNext ()Z
IFEQ L3
ALOAD 2
INVOKEINTERFACE java/util/Iterator.next ()Ljava/lang/Object;
<contents of the loop>
GOTO L2
L3