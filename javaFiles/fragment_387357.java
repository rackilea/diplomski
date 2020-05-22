Decoding compiled method 0x0000000002885d50:
Code:
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} {0x0000000055360550} &apos;runChained&apos; &apos;(LChainA;I)V&apos; in &apos;Chaining&apos;
  # parm0:    rdx:rdx   = &apos;ChainA&apos;
  # parm1:    r8        = int
  #           [sp+0x30]  (sp of caller)
  0x0000000002885e80: mov    %eax,-0x6000(%rsp)
  0x0000000002885e87: push   %rbp
  0x0000000002885e88: sub    $0x20,%rsp         ;*synchronization entry
                                                ; - Chaining::runChained@-1 (line 47)

  0x0000000002885e8c: mov    %rdx,%r9
  0x0000000002885e8f: mov    %r8d,%ebx
  0x0000000002885e92: test   %r8d,%r8d
  0x0000000002885e95: jle    0x0000000002885f8a  ;*if_icmpge
                                                ; - Chaining::runChained@4 (line 47)

  0x0000000002885e9b: mov    0xc(%rdx),%r11d    ;*getfield b
                                                ; - ChainA::getB@1 (line 4)
                                                ; - Chaining::runChained@8 (line 49)
                                                ; implicit exception: dispatches to 0x0000000002885f96
  0x0000000002885e9f: mov    0xc(%r11),%r10d    ;*getfield c
                                                ; - ChainB::getC@1 (line 10)
                                                ; - Chaining::runChained@11 (line 49)
                                                ; implicit exception: dispatches to 0x0000000002885f96

    0x0000000002885ea3: mov    0xc(%r10),%edx     ;*getfield d
                                                ; - ChainC::getD@1 (line 16)
                                                ; - Chaining::runChained@14 (line 49)
                                                ; implicit exception: dispatches to 0x0000000002885f96
  0x0000000002885ea7: mov    0xc(%rdx),%r11d    ;*getfield result
                                                ; - ChainD::doSomething1@2 (line 23)
                                                ; - Chaining::runChained@17 (line 49)
                                                ; implicit exception: dispatches to 0x0000000002885f96
  0x0000000002885eab: xor    %r10d,%r10d
  0x0000000002885eae: xor    %esi,%esi
  0x0000000002885eb0: xor    %r8d,%r8d
  0x0000000002885eb3: xor    %ecx,%ecx          ;*aload_0
                                                ; - Chaining::runChained@7 (line 49)

  0x0000000002885eb5: add    %r11d,%esi         ;*getfield result
                                                ; - ChainD::doSomething1@2 (line 23)
                                                ; - Chaining::runChained@17 (line 49)

  0x0000000002885eb8: add    %ecx,%r8d
  0x0000000002885ebb: mov    %esi,%eax
  0x0000000002885ebd: add    $0x6,%eax          ;*iadd
                                                ; - ChainD::doSomething3@6 (line 25)
                                                ; - Chaining::runChained@43 (line 51)

  0x0000000002885ec0: mov    %eax,0xc(%rdx)     ;*putfield result
                                                ; - ChainD::doSomething3@7 (line 25)
                                                ; - Chaining::runChained@43 (line 51)

  0x0000000002885ec3: mov    %r10d,%edi
  0x0000000002885ec6: inc    %edi               ;*iinc
                                                ; - Chaining::runChained@46 (line 47)

  0x0000000002885ec8: cmp    $0x1,%edi
  0x0000000002885ecb: jge    0x0000000002885eee  ;*if_icmpge
                                                ; - Chaining::runChained@4 (line 47)

  0x0000000002885ecd: mov    %r10d,%ecx
  0x0000000002885ed0: shl    %ecx
  0x0000000002885ed2: mov    %r8d,%esi
  0x0000000002885ed5: add    $0x6,%esi
  0x0000000002885ed8: mov    %ecx,%r8d
  0x0000000002885edb: add    $0x2,%r8d
  0x0000000002885edf: shl    $0x2,%r10d
  0x0000000002885ee3: mov    %r10d,%ecx
  0x0000000002885ee6: add    $0x4,%ecx
  0x0000000002885ee9: mov    %edi,%r10d
  0x0000000002885eec: jmp    0x0000000002885eb5
  0x0000000002885eee: mov    %ebx,%r11d
  0x0000000002885ef1: add    $0xfffffff1,%r11d
  0x0000000002885ef5: mov    $0x80000000,%r9d
  0x0000000002885efb: cmp    %r11d,%ebx
  0x0000000002885efe: cmovl  %r9d,%r11d
  0x0000000002885f02: cmp    %r11d,%edi
  0x0000000002885f05: jge    0x0000000002885f3c
  0x0000000002885f07: sub    %r8d,%esi
  0x0000000002885f0a: nopw   0x0(%rax,%rax,1)   ;*aload_0
                                                ; - Chaining::runChained@7 (line 49)

  0x0000000002885f10: mov    %edi,%r8d
  0x0000000002885f13: shl    %r8d
  0x0000000002885f16: mov    %edi,%r9d
  0x0000000002885f19: shl    $0x2,%r9d
  0x0000000002885f1d: add    %r9d,%r8d
  0x0000000002885f20: add    %esi,%r8d          ;*getfield result
                                                ; - ChainD::doSomething1@2 (line 23)
                                                ; - Chaining::runChained@17 (line 49)

  0x0000000002885f23: mov    %r8d,%eax
  0x0000000002885f26: add    $0x60,%eax         ;*iadd
                                                ; - ChainD::doSomething3@6 (line 25)
                                                ; - Chaining::runChained@43 (line 51)

  0x0000000002885f29: add    $0x5a,%r8d
  0x0000000002885f2d: mov    %r8d,0xc(%rdx)
  0x0000000002885f31: mov    %eax,0xc(%rdx)     ;*putfield result
                                                ; - ChainD::doSomething3@7 (line 25)
                                                ; - Chaining::runChained@43 (line 51)

  0x0000000002885f34: add    $0x10,%edi         ;*iinc
                                                ; - Chaining::runChained@46 (line 47)

  0x0000000002885f37: cmp    %r11d,%edi
  0x0000000002885f3a: jl     0x0000000002885f10  ;*getfield result
                                                ; - ChainD::doSomething1@2 (line 23)
                                                ; - Chaining::runChained@17 (line 49)

  0x0000000002885f3c: cmp    %ebx,%edi
  0x0000000002885f3e: jge    0x0000000002885f8a
  0x0000000002885f40: mov    %edi,%r10d
  0x0000000002885f43: shl    $0x2,%r10d
  0x0000000002885f47: mov    %edi,%r11d
  0x0000000002885f4a: shl    %r11d
  0x0000000002885f4d: mov    %r11d,%r8d
  0x0000000002885f50: add    %r10d,%r8d
  0x0000000002885f53: sub    %r8d,%eax
  0x0000000002885f56: xchg   %ax,%ax            ;*aload_0
                                                ; - Chaining::runChained@7 (line 49)

  0x0000000002885f58: add    %r11d,%r10d
  0x0000000002885f5b: add    %eax,%r10d
  0x0000000002885f5e: add    $0x6,%r10d
  0x0000000002885f62: mov    %r10d,0xc(%rdx)    ;*putfield result
                                                ; - ChainD::doSomething3@7 (line 25)
                                                ; - Chaining::runChained@43 (line 51)

  0x0000000002885f66: mov    %edi,%r8d
  0x0000000002885f69: inc    %r8d               ;*iinc
                                                ; - Chaining::runChained@46 (line 47)

  0x0000000002885f6c: cmp    %ebx,%r8d
  0x0000000002885f6f: jge    0x0000000002885f8a
  0x0000000002885f71: mov    %edi,%r10d
  0x0000000002885f74: shl    $0x2,%r10d
  0x0000000002885f78: shl    %edi
  0x0000000002885f7a: add    $0x4,%r10d
  0x0000000002885f7e: mov    %edi,%r11d
  0x0000000002885f81: add    $0x2,%r11d
  0x0000000002885f85: mov    %r8d,%edi
  0x0000000002885f88: jmp    0x0000000002885f58  ;*if_icmpge
                                                ; - Chaining::runChained@4 (line 47)

  0x0000000002885f8a: add    $0x20,%rsp
  0x0000000002885f8e: pop    %rbp
  0x0000000002885f8f: test   %eax,-0x26c5f95(%rip)        # 0x00000000001c0000
                                                ;   {poll_return}
  0x0000000002885f95: retq   
  0x0000000002885f96: mov    $0xffffff86,%edx
  0x0000000002885f9b: mov    %r9,%rbp
  0x0000000002885f9e: mov    %r8d,(%rsp)
  0x0000000002885fa2: nop
  0x0000000002885fa3: callq  0x00000000027b7320  ; OopMap{rbp=Oop off=296}
                                                ;*aload_0
                                                ; - Chaining::runChained@7 (line 49)
                                                ;   {runtime_call}
  0x0000000002885fa8: int3                      ;*aload_0
                                                ; - Chaining::runChained@7 (line 49)

  0x0000000002885fa9: hlt    
  0x0000000002885faa: hlt    
  0x0000000002885fab: hlt    
  0x0000000002885fac: hlt    
  0x0000000002885fad: hlt    
  0x0000000002885fae: hlt    
  0x0000000002885faf: hlt    
  0x0000000002885fb0: hlt    
  0x0000000002885fb1: hlt    
  0x0000000002885fb2: hlt    
  0x0000000002885fb3: hlt    
  0x0000000002885fb4: hlt    
  0x0000000002885fb5: hlt    
  0x0000000002885fb6: hlt    
  0x0000000002885fb7: hlt    
  0x0000000002885fb8: hlt    
  0x0000000002885fb9: hlt    
  0x0000000002885fba: hlt    
  0x0000000002885fbb: hlt    
  0x0000000002885fbc: hlt    
  0x0000000002885fbd: hlt    
  0x0000000002885fbe: hlt    
  0x0000000002885fbf: hlt    
[Exception Handler]
[Stub Code]
  0x0000000002885fc0: jmpq   0x00000000028694a0  ;   {no_reloc}
[Deopt Handler Code]
  0x0000000002885fc5: callq  0x0000000002885fca
  0x0000000002885fca: subq   $0x5,(%rsp)
  0x0000000002885fcf: jmpq   0x00000000027b6f40  ;   {runtime_call}
  0x0000000002885fd4: hlt    
  0x0000000002885fd5: hlt    
  0x0000000002885fd6: hlt    
  0x0000000002885fd7: hlt