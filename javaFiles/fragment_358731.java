mov r10d,DWORD PTR [rsi+0x8]
shl    r10,0x3
cmp    rax,r10
jne    0x00007fb509045b60        ;   {runtime_call}
data32 xchg ax,ax
nop    WORD PTR [rax+rax*1+0x0]
nop    WORD PTR [rax+rax*1+0x0]
[Verified Entry Point]
sub    rsp,0x18
mov    QWORD PTR [rsp+0x10],rbp  ;*synchronization entry
                                 ;- Main$TestClass::myFunction@-1 (line 25)

mov    eax,DWORD PTR [rsi+0x10]
imul   eax,DWORD PTR [rsi+0xc]
add    eax,DWORD PTR [rsi+0x14]  ;*iadd 
                                 ;- Main$TestClass::myFunction@13 (line 25)
add    rsp,0x10
pop    rbp
test   DWORD PTR [rip+0x15f7a8bf],eax        # 0x00007fb51f087000 
                                 ;{poll_return}
ret