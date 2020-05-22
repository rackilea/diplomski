0x00007fa35505f20c: xor    %r10d,%r10d
  0x00007fa35505f20f: xor    %r8d,%r8d          ;*lload
                                                ; - weird::main@171 (line 53)
  0x00007fa35505f212: mov    %r8d,0x10(%rsp)
  0x00007fa35505f217: mov    %r10,0x8(%rsp)
  0x00007fa35505f21c: mov    %rbp,%rsi
  0x00007fa35505f21f: callq  0x00007fa355037c60  ; OopMap{rbp=Oop off=580}
                                                ;*invokevirtual getNext
                                                ; - weird::main@174 (line 53)
                                                ;   {optimized virtual_call}
  0x00007fa35505f224: mov    0x8(%rsp),%r10
  0x00007fa35505f229: add    %rax,%r10          ;*ladd
                                                ; - weird::main@177 (line 53)
  0x00007fa35505f22c: mov    0x10(%rsp),%r8d
  0x00007fa35505f231: inc    %r8d               ;*iinc
                                                ; - weird::main@180 (line 52)
  0x00007fa35505f234: cmp    $0x5f5e100,%r8d
  0x00007fa35505f23b: jl     0x00007fa35505f212  ;*if_icmpge
                                                ; - weird::main@168 (line 52)