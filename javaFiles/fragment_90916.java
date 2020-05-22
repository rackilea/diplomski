int[a]={20,10,65,95,110,200,60,700,5}
 i=0, result = 0 (minimum from all previous values = 20 and value = 20) 
 i=1 result = 0 (minimum = 20, value = 10)
 ...
 i=7, result = 700 -10 (minium = 10, value = 700)
 i=8, result = -5 (miniumum= 10, value = 5)

 max(0,0..,700-10,-5) = 700-10