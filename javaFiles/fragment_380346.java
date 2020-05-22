[Disassembling for mach='i386:x86-64']
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} 'frobincate' '()V' in 'Foo'
  #           [sp+0x20]  (sp of caller)
  0x00007fd335060aa0: mov    %eax,-0x14000(%rsp)
  0x00007fd335060aa7: push   %rbp
  0x00007fd335060aa8: sub    $0x10,%rsp         ;*synchronization entry
                                                ; - Foo::frobincate@-1 (line 4)
  0x00007fd335060aac: mov    0x60(%r15),%rdi
  0x00007fd335060ab0: mov    %rdi,%r10
  0x00007fd335060ab3: add    $0xfb0,%r10
  0x00007fd335060aba: cmp    0x70(%r15),%r10
  0x00007fd335060abe: jae    0x00007fd335060b18
  0x00007fd335060ac0: mov    %r10,0x60(%r15)
  0x00007fd335060ac4: prefetchnta 0xc0(%r10)
  0x00007fd335060acc: movq   $0x1,(%rdi)
  0x00007fd335060ad3: prefetchnta 0x100(%r10)
  0x00007fd335060adb: movl   $0xe7780204,0x8(%rdi)  ;   {oop({type array int})}
  0x00007fd335060ae2: prefetchnta 0x140(%r10)
  0x00007fd335060aea: movl   $0x3e8,0xc(%rdi)
  0x00007fd335060af1: prefetchnta 0x180(%r10)
  0x00007fd335060af9: add    $0x10,%rdi
  0x00007fd335060afd: mov    $0x1f4,%ecx
  0x00007fd335060b02: xor    %rax,%rax
  0x00007fd335060b05: shl    $0x3,%rcx
  0x00007fd335060b09: rex.W rep stos %al,%es:(%rdi)
  0x00007fd335060b0c: add    $0x10,%rsp
  0x00007fd335060b10: pop    %rbp
  0x00007fd335060b11: test   %eax,0xbb954e9(%rip)        # 0x00007fd340bf6000
                                                ;   {poll_return}
  0x00007fd335060b17: retq   
  0x00007fd335060b18: mov    $0x3e8,%edx
  0x00007fd335060b1d: mov    $0x73bc01020,%rsi  ;   {oop({type array int})}
  0x00007fd335060b27: callq  0x00007fd33505f260  ; OopMap{off=140}
                                                ;*newarray
                                                ; - Foo::frobincate@3 (line 4)
                                                ;   {runtime_call}
  0x00007fd335060b2c: jmp    0x00007fd335060b0c  ;*newarray
                                                ; - Foo::frobincate@3 (line 4)
  0x00007fd335060b2e: mov    %rax,%rsi
  0x00007fd335060b31: add    $0x10,%rsp
  0x00007fd335060b35: pop    %rbp
  0x00007fd335060b36: jmpq   0x00007fd335062160  ;   {runtime_call}
  0x00007fd335060b3b: hlt    
  0x00007fd335060b3c: hlt    
  0x00007fd335060b3d: hlt    
  0x00007fd335060b3e: hlt    
  0x00007fd335060b3f: hlt    
[Exception Handler]
[Stub Code]
  0x00007fd335060b40: jmpq   0x00007fd33505f3e0  ;   {no_reloc}
[Deopt Handler Code]
  0x00007fd335060b45: callq  0x00007fd335060b4a
  0x00007fd335060b4a: subq   $0x5,(%rsp)
  0x00007fd335060b4f: jmpq   0x00007fd335038f00  ;   {runtime_call}
  0x00007fd335060b54: hlt    
  0x00007fd335060b55: hlt    
  0x00007fd335060b56: hlt    
  0x00007fd335060b57: hlt