# (?i)\d(?:[a-z][a-z\d]{2,3}|\d[a-z][a-z\d]{1,2}|\d\d[a-z][a-z\d]{0,1}|\d\d\d[a-z])\d

 (?i)
 \d 
 (?:
      [a-z] 
      [a-z\d]{2,3} 
   |  
      \d 
      [a-z] 
      [a-z\d]{1,2} 
   |  
      \d\d 
      [a-z] 
      [a-z\d]{0,1} 
   |  
      \d\d\d 
      [a-z] 
 )
 \d