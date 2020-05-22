// if (x > -1) {...
cmp_gt  PROC
  00000 83 f9 ff     cmp     ecx, -1
  00003 48 8d 0d 00 00                  // speculative load of argument to my_puts()
    00 00        lea     rcx, OFFSET FLAT:$SG1359
  0000a 7f 07        jg  SHORT $LN5@cmp_gt

// if (x >= 0) {...
cmp_gte PROC
  00000 85 c9        test    ecx, ecx
  00002 48 8d 0d 00 00                  // speculative load of argument to my_puts()
    00 00        lea     rcx, OFFSET FLAT:$SG1367
  00009 79 07        jns     SHORT $LN5@cmp_gte