// if (x > -1) {...
cmp_gt:
    .fnstart
.LFB0:
    cmp r0, #0
    blt .L8

// if (x >= 0) {...
cmp_gte:
    .fnstart
.LFB1:
    cmp r0, #0
    blt .L2