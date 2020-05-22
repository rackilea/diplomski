# {method} {0x000000001e142de0} 'lambda$main$0' '(I)V' in 'Race'
  # parm0:    rdx       = int
  #           [sp+0x20]  (sp of caller)
  0x00000000052eb740: sub     rsp,18h
  0x00000000052eb747: mov     qword ptr [rsp+10h],rbp  ;*synchronization entry
                                                ; - Race::lambda$main$0@-1 (line 8)

  0x00000000052eb74c: mov     r10,76b8940c0h    ;   {oop(a 'java/lang/Class' = 'Race')}
  0x00000000052eb756: mov     dword ptr [r10+68h],3h  ;*putstatic a
                                                ; - Race::lambda$main$0@9 (line 10)

  0x00000000052eb75e: add     rsp,10h
  0x00000000052eb762: pop     rbp
  0x00000000052eb763: test    dword ptr [3470000h],eax
                                                ;   {poll_return}
  0x00000000052eb769: ret