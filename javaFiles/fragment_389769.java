Decoding compiled method 0x00b51488:
Code:
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} {0x3d90046c} &apos;processStringTest&apos; &apos;(LDummyString;)I&apos; in &apos;NestedNullCheckTest&apos;
  # parm0:    ecx       = &apos;DummyString&apos;
  #           [sp+0x10]  (sp of caller)
  0x00b51580: sub    $0xc,%esp
  0x00b51586: mov    %ebp,0x8(%esp)     ;*synchronization entry
                                        ; - NestedNullCheckTest::processStringTest@-1 (line 30)

  0x00b5158a: test   %ecx,%ecx
  0x00b5158c: je     0x00b515a4         ;*ifnonnull
                                        ; - NestedNullCheckTest::processStringTest@1 (line 30)

  0x00b5158e: mov    0x8(%ecx),%eax
  0x00b51591: shl    %eax
  0x00b51593: add    $0xfffffffe,%eax   ;*imul
                                        ; - NestedNullCheckC::processStringC@13 (line 103)
                                        ; - NestedNullCheckB::processStringB@18 (line 90)
                                        ; - NestedNullCheckA::processStringA@18 (line 76)
                                        ; - NestedNullCheckTest::processStringTest@7 (line 34)

  0x00b51596: mov    %eax,0x8(%ecx)     ;*putfield value
                                        ; - NestedNullCheckC::processStringC@14 (line 103)
                                        ; - NestedNullCheckB::processStringB@18 (line 90)
                                        ; - NestedNullCheckA::processStringA@18 (line 76)
                                        ; - NestedNullCheckTest::processStringTest@7 (line 34)

  0x00b51599: add    $0x8,%esp
  0x00b5159c: pop    %ebp
  0x00b5159d: test   %eax,0x970000      ;   {poll_return}
  0x00b515a3: ret    
  0x00b515a4: mov    $0xffffffff,%eax
  0x00b515a9: jmp    0x00b51599
  0x00b515ab: hlt    
  ...
  0x00b515bf: hlt    
[Exception Handler]
[Stub Code]
  0x00b515c0: jmp    0x00af5e40         ;   {no_reloc}
[Deopt Handler Code]
  0x00b515c5: push   $0xb515c5          ;   {section_word}
  0x00b515ca: jmp    0x00adbfc0         ;   {runtime_call}
  0x00b515cf: hlt