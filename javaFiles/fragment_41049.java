if (p == 1)
    goto .L1;
else if (p == 2)
    goto .L2;
else if (p == 3)
    goto .L3;
else
    goto .L4;

.L1:
    x--;
.L2:
    x = 2;
.L3:
    x = 3;
.L4:
    x++;