mov     0x8(%r11),%r10d    ; read the klass ptr
   cmp     $0x20002192,%r10d  ;   klass for 'java/lang/Double'
   jne     NOT_EQUAL          ; not equal? slow branch
   mov     $0x1,%eax          ; return value = "true"
RETURN:
   add     $0x10,%rsp         ; epilog
   pop     %rbp
   test    %eax,0x16774469(%rip) 
   retq
NOT_EQUAL:
   xor     %eax,%eax          ; return value = "false"
   jmp     RETURN