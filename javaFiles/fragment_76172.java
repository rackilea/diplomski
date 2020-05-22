// if (x > -1) {...
00000        |cmp_gt| PROC
  00000 f1b0 3fff    cmp         r0,#0xFFFFFFFF
  00004 dd05         ble         |$LN2@cmp_gt|


// if (x >= 0) {...
  00024      |cmp_gte| PROC
  00024 2800         cmp         r0,#0
  00026 db05         blt         |$LN2@cmp_gte|