// if (x > -1) {...
cmp_gt:
80B5 PUSH     {R7,LR}
.... LDR.N    R1,??DataTable1  ;; `?<Constant "non-negative">`
0028 CMP      R0,#+0
01D4 BMI.N    ??cmp_gt_0

// if (x >= 0) {...
cmp_gte:
 80B5 PUSH     {R7,LR}
 .... LDR.N    R1,??DataTable1  ;; `?<Constant "non-negative">`
 0028 CMP      R0,#+0
 01D4 BMI.N    ??cmp_gte_0