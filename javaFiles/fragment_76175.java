// if (x > -1) {...
cmp_gt:
    .seh_endprologue
    test    ecx, ecx
    js  .L2

// if (x >= 0) {...
cmp_gte:
    .seh_endprologue
    test    ecx, ecx
    js  .L5