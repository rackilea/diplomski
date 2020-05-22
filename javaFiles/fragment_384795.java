[Verified Entry Point]
  # {method} 'multiplyByPowerOfTen' '(DI)D' in 'javaapplication4/Test1'
  # parm0:    xmm0:xmm0   = double
  # parm1:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x000000000287fe20: mov    DWORD PTR [rsp-0x6000],eax
                                                ;   {no_reloc}
  0x000000000287fe27: push   rbp
  0x000000000287fe28: sub    rsp,0x10           ;*synchronization entry
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@-1 (line 56)
  0x000000000287fe2c: cmp    edx,0x13
  0x000000000287fe2f: jae    0x000000000287fe46
  0x000000000287fe31: movsxd r10,edx
  0x000000000287fe34: shl    r10,0x3
  0x000000000287fe38: movabs r8,0x287fd70       ;   {section_word}
  0x000000000287fe42: jmp    QWORD PTR [r8+r10*1]  ;*tableswitch
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@1 (line 56)
  0x000000000287fe46: mov    ebp,edx
  0x000000000287fe48: mov    edx,0x31
  0x000000000287fe4d: xchg   ax,ax
  0x000000000287fe4f: call   0x00000000028590a0  ; OopMap{off=52}
                                                ;*new  ; - javaapplication4.Test1::multiplyByPowerOfTen@202 (line 96)
                                                ;   {runtime_call}
  0x000000000287fe54: int3                      ;*new  ; - javaapplication4.Test1::multiplyByPowerOfTen@202 (line 96)
  0x000000000287fe55: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe8b]        # 0x000000000287fce8
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@194 (line 92)
                                                ;   {section_word}
  0x000000000287fe5d: jmp    0x000000000287ff16
  0x000000000287fe62: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe86]        # 0x000000000287fcf0
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@188 (line 90)
                                                ;   {section_word}
  0x000000000287fe6a: jmp    0x000000000287ff16
  0x000000000287fe6f: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe81]        # 0x000000000287fcf8
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@182 (line 88)
                                                ;   {section_word}
  0x000000000287fe77: jmp    0x000000000287ff16
  0x000000000287fe7c: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe7c]        # 0x000000000287fd00
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@176 (line 86)
                                                ;   {section_word}
  0x000000000287fe84: jmp    0x000000000287ff16
  0x000000000287fe89: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe77]        # 0x000000000287fd08
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@170 (line 84)
                                                ;   {section_word}
  0x000000000287fe91: jmp    0x000000000287ff16
  0x000000000287fe96: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe72]        # 0x000000000287fd10
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@164 (line 82)
                                                ;   {section_word}
  0x000000000287fe9e: jmp    0x000000000287ff16
  0x000000000287fea0: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe70]        # 0x000000000287fd18
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@158 (line 80)
                                                ;   {section_word}
  0x000000000287fea8: jmp    0x000000000287ff16
  0x000000000287feaa: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe6e]        # 0x000000000287fd20
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@152 (line 78)
                                                ;   {section_word}
  0x000000000287feb2: jmp    0x000000000287ff16
  0x000000000287feb4: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe24]        # 0x000000000287fce0
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@146 (line 76)
                                                ;   {section_word}
  0x000000000287febc: jmp    0x000000000287ff16
  0x000000000287febe: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe6a]        # 0x000000000287fd30
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@140 (line 74)
                                                ;   {section_word}
  0x000000000287fec6: jmp    0x000000000287ff16
  0x000000000287fec8: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe68]        # 0x000000000287fd38
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@134 (line 72)
                                                ;   {section_word}
  0x000000000287fed0: jmp    0x000000000287ff16
  0x000000000287fed2: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe66]        # 0x000000000287fd40
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@128 (line 70)
                                                ;   {section_word}
  0x000000000287feda: jmp    0x000000000287ff16
  0x000000000287fedc: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe64]        # 0x000000000287fd48
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@122 (line 68)
                                                ;   {section_word}
  0x000000000287fee4: jmp    0x000000000287ff16
  0x000000000287fee6: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe62]        # 0x000000000287fd50
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@116 (line 66)
                                                ;   {section_word}
  0x000000000287feee: jmp    0x000000000287ff16
  0x000000000287fef0: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe60]        # 0x000000000287fd58
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@110 (line 64)
                                                ;   {section_word}
  0x000000000287fef8: jmp    0x000000000287ff16
  0x000000000287fefa: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe5e]        # 0x000000000287fd60
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@104 (line 62)
                                                ;   {section_word}
  0x000000000287ff02: jmp    0x000000000287ff16
  0x000000000287ff04: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe5c]        # 0x000000000287fd68
                                                ;*dmul
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@98 (line 60)
                                                ;   {section_word}
  0x000000000287ff0c: jmp    0x000000000287ff16
  0x000000000287ff0e: mulsd  xmm0,QWORD PTR [rip+0xfffffffffffffe12]        # 0x000000000287fd28
                                                ;*tableswitch
                                                ; - javaapplication4.Test1::multiplyByPowerOfTen@1 (line 56)
                                                ;   {section_word}
  0x000000000287ff16: add    rsp,0x10
  0x000000000287ff1a: pop    rbp
  0x000000000287ff1b: test   DWORD PTR [rip+0xfffffffffd9b00df],eax        # 0x0000000000230000
                                                ;   {poll_return}
  0x000000000287ff21: ret