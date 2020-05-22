0x00007fb9f356a380: mov    %eax,-0x14000(%rsp)
  0x00007fb9f356a387: push   %rbp
  0x00007fb9f356a388: sub    $0x40,%rsp
  0x00007fb9f356a38c: lea    0x20(%rsp),%rdi
  0x00007fb9f356a391: mov    %rsi,0x8(%rdi)
  0x00007fb9f356a395: mov    (%rsi),%rax
  0x00007fb9f356a398: mov    %rax,%rbx
  0x00007fb9f356a39b: and    $0x7,%rbx
  0x00007fb9f356a39f: cmp    $0x5,%rbx
  0x00007fb9f356a3a3: jne    0x00007fb9f356a42a
  0x00007fb9f356a3a9: mov    0x8(%rsi),%ebx
  0x00007fb9f356a3ac: shl    $0x3,%rbx
  0x00007fb9f356a3b0: mov    0xa8(%rbx),%rbx
  0x00007fb9f356a3b7: or     %r15,%rbx
  0x00007fb9f356a3ba: xor    %rax,%rbx
  0x00007fb9f356a3bd: and    $0xffffffffffffff87,%rbx
  0x00007fb9f356a3c1: je     0x00007fb9f356a452
  0x00007fb9f356a3c7: test   $0x7,%rbx
  0x00007fb9f356a3ce: jne    0x00007fb9f356a417
  0x00007fb9f356a3d0: test   $0x300,%rbx
  0x00007fb9f356a3d7: jne    0x00007fb9f356a3f6
  0x00007fb9f356a3d9: and    $0x37f,%rax
  0x00007fb9f356a3e0: mov    %rax,%rbx
  0x00007fb9f356a3e3: or     %r15,%rbx
  0x00007fb9f356a3e6: lock cmpxchg %rbx,(%rsi)
  0x00007fb9f356a3eb: jne    0x00007fb9f356a497
  0x00007fb9f356a3f1: jmpq   0x00007fb9f356a452
  0x00007fb9f356a3f6: mov    0x8(%rsi),%ebx
  0x00007fb9f356a3f9: shl    $0x3,%rbx
  0x00007fb9f356a3fd: mov    0xa8(%rbx),%rbx
  0x00007fb9f356a404: or     %r15,%rbx
  0x00007fb9f356a407: lock cmpxchg %rbx,(%rsi)
  0x00007fb9f356a40c: jne    0x00007fb9f356a497
  0x00007fb9f356a412: jmpq   0x00007fb9f356a452
  0x00007fb9f356a417: mov    0x8(%rsi),%ebx
  0x00007fb9f356a41a: shl    $0x3,%rbx
  0x00007fb9f356a41e: mov    0xa8(%rbx),%rbx
  0x00007fb9f356a425: lock cmpxchg %rbx,(%rsi)
  0x00007fb9f356a42a: mov    (%rsi),%rax
  0x00007fb9f356a42d: or     $0x1,%rax
  0x00007fb9f356a431: mov    %rax,(%rdi)
  0x00007fb9f356a434: lock cmpxchg %rdi,(%rsi)
  0x00007fb9f356a439: je     0x00007fb9f356a452
  0x00007fb9f356a43f: sub    %rsp,%rax
  0x00007fb9f356a442: and    $0xfffffffffffff007,%rax
  0x00007fb9f356a449: mov    %rax,(%rdi)
  0x00007fb9f356a44c: jne    0x00007fb9f356a497  ;*aload_0
                                                ; - SynchronizedCounter::inc@0 (line 21)

  0x00007fb9f356a452: mov    0xc(%rsi),%eax     ;*getfield counter
                                                ; - SynchronizedCounter::inc@2 (line 21)

  0x00007fb9f356a455: inc    %eax
  0x00007fb9f356a457: mov    %eax,0xc(%rsi)     ;*putfield counter
                                                ; - SynchronizedCounter::inc@7 (line 21)

  0x00007fb9f356a45a: lea    0x20(%rsp),%rax
  0x00007fb9f356a45f: mov    0x8(%rax),%rdi
  0x00007fb9f356a463: mov    (%rdi),%rsi
  0x00007fb9f356a466: and    $0x7,%rsi
  0x00007fb9f356a46a: cmp    $0x5,%rsi
  0x00007fb9f356a46e: je     0x00007fb9f356a48b
  0x00007fb9f356a474: mov    (%rax),%rsi
  0x00007fb9f356a477: test   %rsi,%rsi
  0x00007fb9f356a47a: je     0x00007fb9f356a48b
  0x00007fb9f356a480: lock cmpxchg %rsi,(%rdi)
  0x00007fb9f356a485: jne    0x00007fb9f356a4a7  ;*return
                                                ; - SynchronizedCounter::inc@10