0x00007fcdb12bc6c0: mov    %r9d,%r11d
  0x00007fcdb12bc6c3: add    %r8d,%r11d
  0x00007fcdb12bc6c6: mov    %r11d,%ecx
  0x00007fcdb12bc6c9: add    $0x10,%ecx
  0x00007fcdb12bc6cc: mov    %ecx,0xc(%r10)     ;*putfield counter
                                                ; - Counter::inc@7 (line 14)
                                                ; - Inc::run@12 (line 53)

  0x00007fcdb12bc6d0: add    $0x10,%r9d         ;*iinc
                                                ; - Inc::run@17 (line 52)

  0x00007fcdb12bc6d4: cmp    $0x7ffffff0,%r9d
  0x00007fcdb12bc6db: jl     0x00007fcdb12bc6c0  ;*if_icmpge
                                                ; - Inc::run@5 (line 52)