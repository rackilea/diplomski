0x0000000002df4dd0: inc    %ebp               ; OopMap{r11=Derived_oop_rbx rbx=Oop off=114}
                                              ;*goto
                                              ; - NestedLoop::inline@53 (line 12)

0x0000000002df4dd2: test   %eax,-0x1d64dd8(%rip)        # 0x0000000001090000
                                              ;*iload
                                              ; - NestedLoop::inline@21 (line 12)
                                              ;   {poll}
0x0000000002df4dd8: cmp    $0x1388,%ebp
0x0000000002df4dde: jge    0x0000000002df4dfd  ;*if_icmpge
                                              ; - NestedLoop::inline@26 (line 12)

0x0000000002df4de0: test   %rbx,%rbx
0x0000000002df4de3: je     0x0000000002df4e4c
0x0000000002df4de5: mov    (%r11),%r10d       ;*getfield width
                                              ; - NestedLoop::inline@32 (line 13)

0x0000000002df4de8: mov    0xc(%r10),%r9d     ; implicit exception
0x0000000002df4dec: cmp    %r9d,%ebp
0x0000000002df4def: jae    0x0000000002df4e59
0x0000000002df4df1: mov    0x10(%r10,%rbp,4),%r8d  ;*iaload
                                              ; - NestedLoop::inline@37 (line 13)

0x0000000002df4df6: cmp    %r8d,%r13d
0x0000000002df4df9: jg     0x0000000002df4dc6  ;*if_icmple
                                              ; - NestedLoop::inline@38 (line 13)

0x0000000002df4dfb: jmp    0x0000000002df4dd0