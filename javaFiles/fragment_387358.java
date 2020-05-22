Decoding compiled method 0x00000000028893d0:
Code:
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} {0x0000000055360628} &apos;runUnChained&apos; &apos;(LChainA;I)V&apos; in &apos;Chaining&apos;
  # parm0:    rdx:rdx   = &apos;ChainA&apos;
  # parm1:    r8        = int
  #           [sp+0x30]  (sp of caller)
  0x0000000002889500: mov    %eax,-0x6000(%rsp)
  0x0000000002889507: push   %rbp
  0x0000000002889508: sub    $0x20,%rsp         ;*synchronization entry
                                                ; - Chaining::runUnChained@-1 (line 57)



  0x000000000288950c: mov    0xc(%rdx),%r11d    ;*getfield b
                                                ; - ChainA::getB@1 (line 4)
                                                ; - Chaining::runUnChained@1 (line 57)
                                                ; implicit exception: dispatches to 0x0000000002889612
  0x0000000002889510: mov    0xc(%r11),%r10d    ;*getfield c
                                                ; - ChainB::getC@1 (line 10)
                                                ; - Chaining::runUnChained@4 (line 57)
                                                ; implicit exception: dispatches to 0x000000000288961d
  0x0000000002889514: mov    0xc(%r10),%ebx     ;*getfield d
                                                ; - ChainC::getD@1 (line 16)
                                                ; - Chaining::runUnChained@7 (line 57)
                                                ; implicit exception: dispatches to 0x0000000002889629
  0x0000000002889518: mov    %r8d,%esi
  0x000000000288951b: test   %r8d,%r8d
  0x000000000288951e: jle    0x0000000002889606  ;*if_icmpge
                                                ; - Chaining::runUnChained@15 (line 58)

  0x0000000002889524: mov    0xc(%rbx),%r10d    ;*getfield result
                                                ; - ChainD::doSomething1@2 (line 23)
                                                ; - Chaining::runUnChained@19 (line 60)
                                                ; implicit exception: dispatches to 0x0000000002889635
  0x0000000002889528: xor    %r8d,%r8d
  0x000000000288952b: xor    %edx,%edx
  0x000000000288952d: xor    %r9d,%r9d
  0x0000000002889530: xor    %r11d,%r11d        ;*aload_2
                                                ; - Chaining::runUnChained@18 (line 60)

  0x0000000002889533: add    %r10d,%edx         ;*getfield result
                                                ; - ChainD::doSomething1@2 (line 23)
                                                ; - Chaining::runUnChained@19 (line 60)

  0x0000000002889536: add    %r11d,%r9d
  0x0000000002889539: mov    %edx,%edi
  0x000000000288953b: add    $0x6,%edi          ;*iadd
                                                ; - ChainD::doSomething3@6 (line 25)
                                                ; - Chaining::runUnChained@27 (line 62)

  0x000000000288953e: mov    %edi,0xc(%rbx)     ;*putfield result
                                                ; - ChainD::doSomething3@7 (line 25)
                                                ; - Chaining::runUnChained@27 (line 62)

  0x0000000002889541: mov    %r8d,%ecx
  0x0000000002889544: inc    %ecx               ;*iinc
                                                ; - Chaining::runUnChained@30 (line 58)

  0x0000000002889546: cmp    $0x1,%ecx
  0x0000000002889549: jge    0x000000000288956e  ;*if_icmpge
                                                ; - Chaining::runUnChained@15 (line 58)

  0x000000000288954b: mov    %r8d,%r11d
  0x000000000288954e: shl    %r11d
  0x0000000002889551: mov    %r9d,%edx
  0x0000000002889554: add    $0x6,%edx
  0x0000000002889557: mov    %r11d,%r9d
  0x000000000288955a: add    $0x2,%r9d
  0x000000000288955e: shl    $0x2,%r8d
  0x0000000002889562: mov    %r8d,%r11d
  0x0000000002889565: add    $0x4,%r11d
  0x0000000002889569: mov    %ecx,%r8d
  0x000000000288956c: jmp    0x0000000002889533
  0x000000000288956e: mov    %esi,%r10d
  0x0000000002889571: add    $0xfffffff1,%r10d
  0x0000000002889575: mov    $0x80000000,%r11d
  0x000000000288957b: cmp    %r10d,%esi
  0x000000000288957e: cmovl  %r11d,%r10d
  0x0000000002889582: cmp    %r10d,%ecx
  0x0000000002889585: jge    0x00000000028895bc
  0x0000000002889587: sub    %r9d,%edx
  0x000000000288958a: nopw   0x0(%rax,%rax,1)   ;*aload_2
                                                ; - Chaining::runUnChained@18 (line 60)

  0x0000000002889590: mov    %ecx,%r11d
  0x0000000002889593: shl    %r11d
  0x0000000002889596: mov    %ecx,%r8d
  0x0000000002889599: shl    $0x2,%r8d
  0x000000000288959d: add    %r8d,%r11d
  0x00000000028895a0: add    %edx,%r11d         ;*getfield result
                                                ; - ChainD::doSomething1@2 (line 23)
                                                ; - Chaining::runUnChained@19 (line 60)

  0x00000000028895a3: mov    %r11d,%edi
  0x00000000028895a6: add    $0x60,%edi         ;*iadd
                                                ; - ChainD::doSomething3@6 (line 25)
                                                ; - Chaining::runUnChained@27 (line 62)

  0x00000000028895a9: add    $0x5a,%r11d
  0x00000000028895ad: mov    %r11d,0xc(%rbx)
  0x00000000028895b1: mov    %edi,0xc(%rbx)     ;*putfield result
                                                ; - ChainD::doSomething3@7 (line 25)
                                                ; - Chaining::runUnChained@27 (line 62)

  0x00000000028895b4: add    $0x10,%ecx         ;*iinc
                                                ; - Chaining::runUnChained@30 (line 58)

  0x00000000028895b7: cmp    %r10d,%ecx
  0x00000000028895ba: jl     0x0000000002889590  ;*getfield result
                                                ; - ChainD::doSomething1@2 (line 23)
                                                ; - Chaining::runUnChained@19 (line 60)

  0x00000000028895bc: cmp    %esi,%ecx
  0x00000000028895be: jge    0x0000000002889606
  0x00000000028895c0: mov    %ecx,%r11d
  0x00000000028895c3: shl    $0x2,%r11d
  0x00000000028895c7: mov    %ecx,%r8d
  0x00000000028895ca: shl    %r8d
  0x00000000028895cd: mov    %r8d,%r9d
  0x00000000028895d0: add    %r11d,%r9d
  0x00000000028895d3: sub    %r9d,%edi
  0x00000000028895d6: xchg   %ax,%ax            ;*aload_2
                                                ; - Chaining::runUnChained@18 (line 60)

  0x00000000028895d8: add    %r8d,%r11d
  0x00000000028895db: add    %edi,%r11d
  0x00000000028895de: add    $0x6,%r11d
  0x00000000028895e2: mov    %r11d,0xc(%rbx)    ;*putfield result
                                                ; - ChainD::doSomething3@7 (line 25)
                                                ; - Chaining::runUnChained@27 (line 62)

  0x00000000028895e6: mov    %ecx,%edx
  0x00000000028895e8: inc    %edx               ;*iinc
                                                ; - Chaining::runUnChained@30 (line 58)

  0x00000000028895ea: cmp    %esi,%edx
  0x00000000028895ec: jge    0x0000000002889606
  0x00000000028895ee: mov    %ecx,%r11d
  0x00000000028895f1: shl    $0x2,%r11d
  0x00000000028895f5: shl    %ecx
  0x00000000028895f7: add    $0x4,%r11d
  0x00000000028895fb: mov    %ecx,%r8d
  0x00000000028895fe: add    $0x2,%r8d
  0x0000000002889602: mov    %edx,%ecx
  0x0000000002889604: jmp    0x00000000028895d8  ;*if_icmpge
                                                ; - Chaining::runUnChained@15 (line 58)

  0x0000000002889606: add    $0x20,%rsp
  0x000000000288960a: pop    %rbp
  0x000000000288960b: test   %eax,-0x26c9611(%rip)        # 0x00000000001c0000
                                                ;   {poll_return}
  0x0000000002889611: retq   
  0x0000000002889612: mov    $0xfffffff6,%edx
  0x0000000002889617: callq  0x00000000027b7320  ; OopMap{off=284}
                                                ;*invokevirtual getB
                                                ; - Chaining::runUnChained@1 (line 57)
                                                ;   {runtime_call}
  0x000000000288961c: int3                      ;*invokevirtual getB
                                                ; - Chaining::runUnChained@1 (line 57)

  0x000000000288961d: mov    $0xfffffff6,%edx
  0x0000000002889622: nop
  0x0000000002889623: callq  0x00000000027b7320  ; OopMap{off=296}
                                                ;*invokevirtual getC
                                                ; - Chaining::runUnChained@4 (line 57)
                                                ;   {runtime_call}
  0x0000000002889628: int3                      ;*invokevirtual getC
                                                ; - Chaining::runUnChained@4 (line 57)

  0x0000000002889629: mov    $0xfffffff6,%edx
  0x000000000288962e: nop
  0x000000000288962f: callq  0x00000000027b7320  ; OopMap{off=308}
                                                ;*invokevirtual getD
                                                ; - Chaining::runUnChained@7 (line 57)
                                                ;   {runtime_call}
  0x0000000002889634: int3                      ;*invokevirtual getD
                                                ; - Chaining::runUnChained@7 (line 57)

  0x0000000002889635: mov    $0xffffff86,%edx
  0x000000000288963a: mov    %ebx,%ebp
  0x000000000288963c: mov    %r8d,(%rsp)
  0x0000000002889640: data32 xchg %ax,%ax
  0x0000000002889643: callq  0x00000000027b7320  ; OopMap{rbp=NarrowOop off=328}
                                                ;*aload_2
                                                ; - Chaining::runUnChained@18 (line 60)
                                                ;   {runtime_call}
  0x0000000002889648: int3                      ;*aload_2
                                                ; - Chaining::runUnChained@18 (line 60)

  0x0000000002889649: hlt    
  0x000000000288964a: hlt    
  0x000000000288964b: hlt    
  0x000000000288964c: hlt    
  0x000000000288964d: hlt    
  0x000000000288964e: hlt    
  0x000000000288964f: hlt    
  0x0000000002889650: hlt    
  0x0000000002889651: hlt    
  0x0000000002889652: hlt    
  0x0000000002889653: hlt    
  0x0000000002889654: hlt    
  0x0000000002889655: hlt    
  0x0000000002889656: hlt    
  0x0000000002889657: hlt    
  0x0000000002889658: hlt    
  0x0000000002889659: hlt    
  0x000000000288965a: hlt    
  0x000000000288965b: hlt    
  0x000000000288965c: hlt    
  0x000000000288965d: hlt    
  0x000000000288965e: hlt    
  0x000000000288965f: hlt    
[Exception Handler]
[Stub Code]
  0x0000000002889660: jmpq   0x00000000028694a0  ;   {no_reloc}
[Deopt Handler Code]
  0x0000000002889665: callq  0x000000000288966a
  0x000000000288966a: subq   $0x5,(%rsp)
  0x000000000288966f: jmpq   0x00000000027b6f40  ;   {runtime_call}
  0x0000000002889674: hlt    
  0x0000000002889675: hlt    
  0x0000000002889676: hlt    
  0x0000000002889677: hlt