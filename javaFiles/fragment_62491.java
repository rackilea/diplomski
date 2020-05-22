// 1. Using lambda function
for (int i=1; i<10; 
    [](int i) {for (int j=2; j<10; ++j) 
        printf("%dx%d=%2d ",j,i,i*j);}(i++)) 
    printf("\n");

// 2. Using single for-loop
for (int i=1, j=2; i<10; i=(++j==10) ? i+1 : i, j=(j==10) ? 2 : j) 
    printf("%dx%d=%2d%c",j,i,i*j,(j==9) ? '\n' : ' ');