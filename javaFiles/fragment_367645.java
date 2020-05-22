for(i =0; i < 8; i++)
    {
        for(j = 0; j < 10; j++)
        twoarray[i][j] = (i * 10+j+ 1);
    }
    /* when i=0, j=0, value is 0*10+0+1=1 -->1st Row
         when i=0, j=1, value is 0*10+1+1=2 --> 1st Row
         when i=7,j=0, value is 7*10+0+1=71 --> 8th Row
         when i=7, j=9, value is 7*10+9+1=80 --> 8th Row */