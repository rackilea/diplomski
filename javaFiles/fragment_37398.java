sub $0x18,%rsp
mov %rbp,0x10(%rsp)  ;*synchronization entry
                     ; - Test::lengthTest@-1 (line 12)
mov $0x2a,%eax
add $0x10,%rsp
pop %rbp
test %eax,-0x260e95c(%rip)  # 0x0000000000330000
                            ;   {poll_return}
retq