0x000001bd76170c44: lock cmpxchg %ecx,(%r11)
0x000001bd76170c49: sete   %r10b
0x000001bd76170c4d: movzbl %r10b,%r10d        ;*invokevirtual compareAndSwapInt
                                              ; - WeakVsNonWeak::strong@25 (line 23)
                                              ; - WeakVsNonWeak::main@46 (line 14)

0x0000024f56af1097: lock cmpxchg %r11d,(%r8)
0x0000024f56af109c: sete   %r10b
0x0000024f56af10a0: movzbl %r10b,%r10d        ;*invokevirtual weakCompareAndSwapInt
                                              ; - WeakVsNonWeak::strong@25 (line 23)
                                              ; - WeakVsNonWeak::main@46 (line 14)