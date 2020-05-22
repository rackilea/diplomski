int iValue = numberString.chars()
    .map(n -> Character.digit(n, 10))
    .parallel()
    .collect(()->new int[]{0,1},
             (ia, v) -> { ia[0]=ia[0]*10 + v; ia[1]*=10; },
             (ia1, ia2) -> { ia1[0]=ia1[0]*ia2[1]+ia2[0]; ia1[1]*=ia2[1]; })[0];