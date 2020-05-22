[Verified Entry Point]
  # {method} 'multiplyByPowerOfTen' '(DI)D' in 'javaapplication4/Test1'
  # parm0:    xmm0:xmm0   = double
  # parm1:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x00000000024f0160: mov    DWORD PTR [rsp-0x6000],eax
                                                ;   {no_reloc}
  0x00000000024f0167: push   rbp
  0x00000000024f0168: sub    rsp,0x10           ;*synchronization entry
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@-1 (line 56)
  0x00000000024f016c: cmp    edx,0x3
  0x00000000024f016f: je     0x00000000024f01c3
  0x00000000024f0171: cmp    edx,0x3
  0x00000000024f0174: jg     0x00000000024f01a5
  0x00000000024f0176: cmp    edx,0x1
  0x00000000024f0179: je     0x00000000024f019b
  0x00000000024f017b: cmp    edx,0x1
  0x00000000024f017e: jg     0x00000000024f0191
  0x00000000024f0180: test   edx,edx
  0x00000000024f0182: je     0x00000000024f01cb
  0x00000000024f0184: mov    ebp,edx
  0x00000000024f0186: mov    edx,0x17
  0x00000000024f018b: call   0x00000000024c90a0  ; OopMap{off=48}
                                                ;*new  ; - javaapplication4.Test1::multiplyByPowerOfTen@72 (line 83)
                                                ;   {runtime_call}
  0x00000000024f0190: int3                      ;*new  ; - javaapplication4.Test1::multiplyByPowerOfTen@72 (line 83)
  0x00000000024f0191: mulsd  xmm0,QWORD PTR [rip+0xffffffffffffffa7]        # 0x00000000024f0140
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@52 (line 62)
                                                ;   {section_word}
  0x00000000024f0199: jmp    0x00000000024f01cb
  0x00000000024f019b: mulsd  xmm0,QWORD PTR [rip+0xffffffffffffff8d]        # 0x00000000024f0130
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@46 (line 60)
                                                ;   {section_word}
  0x00000000024f01a3: jmp    0x00000000024f01cb
  0x00000000024f01a5: cmp    edx,0x5
  0x00000000024f01a8: je     0x00000000024f01b9
  0x00000000024f01aa: cmp    edx,0x5
  0x00000000024f01ad: jg     0x00000000024f0184  ;*tableswitch
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@1 (line 56)
  0x00000000024f01af: mulsd  xmm0,QWORD PTR [rip+0xffffffffffffff81]        # 0x00000000024f0138
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@64 (line 66)
                                                ;   {section_word}
  0x00000000024f01b7: jmp    0x00000000024f01cb
  0x00000000024f01b9: mulsd  xmm0,QWORD PTR [rip+0xffffffffffffff67]        # 0x00000000024f0128
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@70 (line 68)
                                                ;   {section_word}
  0x00000000024f01c1: jmp    0x00000000024f01cb
  0x00000000024f01c3: mulsd  xmm0,QWORD PTR [rip+0xffffffffffffff55]        # 0x00000000024f0120
                                                ;*tableswitch
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@1 (line 56)
                                                ;   {section_word}
  0x00000000024f01cb: add    rsp,0x10
  0x00000000024f01cf: pop    rbp
  0x00000000024f01d0: test   DWORD PTR [rip+0xfffffffffdf3fe2a],eax        # 0x0000000000430000
                                                ;   {poll_return}
  0x00000000024f01d6: ret