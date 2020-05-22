javap -verbose -l -private -c -s TestFragment.class > TestFragment.dis

public int setVoice21(java.lang.String, java.lang.String);
    ...
    Exception table:
       from    to  target type
           0    14    17   Class java/util/IllformedLocaleException
    LocalVariableTable:
      Start  Length  Slot  Name   Signature
         18      11     3    ex   Ljava/util/IllformedLocaleException;
          0      31     0  this   Lcom/test/TestFragment;
          0      31     1 language   Ljava/lang/String;
          0      31     2 region   Ljava/lang/String;
    StackMapTable: number_of_entries = 2
      frame_type = 81 /* same_locals_1_stack_item */
        stack = [ class java/util/IllformedLocaleException ]
      frame_type = 11 /* same */