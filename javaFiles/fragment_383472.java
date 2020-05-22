public static void main(java.lang.String[]);
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=2, args_size=1
         0: new           #16                 // class tools/AFoo
         3: dup
         4: invokespecial #18                 // Method tools/AFoo."<init>":()V
         7: astore_1
         8: aload_1
         9: invokeinterface #19,  1           // InterfaceMethod tools/Foo.bar:()V
        14: return