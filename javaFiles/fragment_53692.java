r = (t & 0 < (i +=1));
//true & i +=1 -> i = 1
r = (t && 0 < (i +=2));
//true && i+=2 -> i = 3
r = (t | 0 < (k +=1));
//true | k +=1 -> k = 1
r = (t || 0 < (k +=2));
//true || ... no need to evaluate right side