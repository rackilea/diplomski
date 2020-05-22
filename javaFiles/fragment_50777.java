section .bss
    a resb 1

section .text
global _start
_start:
    xor eax, eax            ; a = 0
    xor cl, cl              ; i = 0

    start_for:
    cmp cl, 20
    jge slutt_for

    cmp cl, 10
    jge else
    inc eax                 ; a++
    jmp slutt_if

    else:
    dec eax                 ; a--

    slutt_if:
    inc cl                 ; i++
    jmp start_for

    slutt_for:
    add al, '0'
    mov [a], al
    mov ecx, a              ; Pointer to a

    write:
    mov eax, 4              ; SYS_WRITE
    mov edx, 1              ; Amount of chars to print
    mov ebx, 1              ; STDOUT
    int 80h

    exit:
    mov ebx, 0              ; return 0
    mov eax, 1
    int 80h