// if (x > -1) {...
_cmp_gt:
    mov eax, DWORD PTR [esp+4]
    test    eax, eax
    js  L2

// if (x >= 0) {...
_cmp_gte:
    mov edx, DWORD PTR [esp+4]
    test    edx, edx
    js  L5