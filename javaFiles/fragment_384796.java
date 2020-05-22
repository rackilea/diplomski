[Verified Entry Point]
  # {method} 'multiplyByPowerOfTen' '(DI)D' in 'javaapplication4/Test1'
  # parm0:    xmm0:xmm0   = double
  # parm1:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x0000000002524560: mov    DWORD PTR [rsp-0x6000],eax
                                                ;   {no_reloc}
  0x0000000002524567: push   rbp
  0x0000000002524568: sub    rsp,0x10           ;*synchronization entry
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@-1 (line 56)
  0x000000000252456c: movapd xmm1,xmm0
  0x0000000002524570: cmp    edx,0x1f
  0x0000000002524573: jae    0x0000000002524592  ;*tableswitch
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@1 (line 56)
  0x0000000002524575: movsxd r10,edx
  0x0000000002524578: shl    r10,0x3
  0x000000000252457c: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe3c]        # 0x00000000025243c0
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@364 (line 118)
                                                ;   {section_word}
  0x0000000002524584: movabs r8,0x2524450       ;   {section_word}
  0x000000000252458e: jmp    QWORD PTR [r8+r10*1]  ;*tableswitch
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@1 (line 56)
  0x0000000002524592: mov    ebp,edx
  0x0000000002524594: mov    edx,0x31
  0x0000000002524599: xchg   ax,ax
  0x000000000252459b: call   0x00000000024f90a0  ; OopMap{off=64}
                                                ;*new  ; - javaapplication4.Test1::multiplyByPowerOfTen@370 (line 120)
                                                ;   {runtime_call}
  0x00000000025245a0: int3                      ;*new  ; - javaapplication4.Test1::multiplyByPowerOfTen@370 (line 120)
  0x00000000025245a1: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe27]        # 0x00000000025243d0
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@358 (line 116)
                                                ;   {section_word}
  0x00000000025245a9: jmp    0x0000000002524744
  0x00000000025245ae: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe22]        # 0x00000000025243d8
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@348 (line 114)
                                                ;   {section_word}
  0x00000000025245b6: jmp    0x0000000002524744
  0x00000000025245bb: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe1d]        # 0x00000000025243e0
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@338 (line 112)
                                                ;   {section_word}
  0x00000000025245c3: jmp    0x0000000002524744
  0x00000000025245c8: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe18]        # 0x00000000025243e8
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@328 (line 110)
                                                ;   {section_word}
  0x00000000025245d0: jmp    0x0000000002524744
  0x00000000025245d5: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe13]        # 0x00000000025243f0
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@318 (line 108)
                                                ;   {section_word}
  0x00000000025245dd: jmp    0x0000000002524744
  0x00000000025245e2: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe0e]        # 0x00000000025243f8
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@308 (line 106)
                                                ;   {section_word}
  0x00000000025245ea: jmp    0x0000000002524744
  0x00000000025245ef: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe09]        # 0x0000000002524400
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@298 (line 104)
                                                ;   {section_word}
  0x00000000025245f7: jmp    0x0000000002524744
  0x00000000025245fc: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe04]        # 0x0000000002524408
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@288 (line 102)
                                                ;   {section_word}
  0x0000000002524604: jmp    0x0000000002524744
  0x0000000002524609: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffdff]        # 0x0000000002524410
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@278 (line 100)
                                                ;   {section_word}
  0x0000000002524611: jmp    0x0000000002524744
  0x0000000002524616: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffdfa]        # 0x0000000002524418
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@268 (line 98)
                                                ;   {section_word}
  0x000000000252461e: jmp    0x0000000002524744
  0x0000000002524623: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffd9d]        # 0x00000000025243c8
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@258 (line 96)
                                                ;   {section_word}
  0x000000000252462b: jmp    0x0000000002524744
  0x0000000002524630: movapd xmm0,xmm1
  0x0000000002524634: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe0c]        # 0x0000000002524448
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@242 (line 92)
                                                ;   {section_word}
  0x000000000252463c: jmp    0x0000000002524744
  0x0000000002524641: movapd xmm0,xmm1
  0x0000000002524645: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffddb]        # 0x0000000002524428
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@236 (line 90)
                                                ;   {section_word}
  0x000000000252464d: jmp    0x0000000002524744
  0x0000000002524652: movapd xmm0,xmm1
  0x0000000002524656: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffdd2]        # 0x0000000002524430
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@230 (line 88)
                                                ;   {section_word}
  0x000000000252465e: jmp    0x0000000002524744
  0x0000000002524663: movapd xmm0,xmm1
  0x0000000002524667: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffdc9]        # 0x0000000002524438
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@224 (line 86)
                                                ;   {section_word}

[etc.]

  0x0000000002524744: add    rsp,0x10
  0x0000000002524748: pop    rbp
  0x0000000002524749: test   DWORD PTR [rip+0xfffffffffde1b8b1],eax        # 0x0000000000340000
                                                ;   {poll_return}
  0x000000000252474f: ret