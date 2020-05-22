// if (x > -1) {...
_cmp_gt PROC
  00000 83 7c 24 04 ff   cmp     DWORD PTR _x$[esp-4], -1
  00005 7e 0d        jle     SHORT $LN2@cmp_gt


// if (x >= 0) {...
_cmp_gte PROC
  00000 83 7c 24 04 00   cmp     DWORD PTR _x$[esp-4], 0
  00005 7c 0d        jl  SHORT $LN2@cmp_gte