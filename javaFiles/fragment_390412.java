Thread1:                                 Thread2:
condition check: i ==0; OK;                condition check: i ==0; OK; 
acquire sem1:                              waiting form sem2
process i =0;                              waiting form sem2  
increase i to 1;                           waiting form sem2
release sem2;                              you acquire sem2 but  i ==1; 
condition check: i ==1; OK;                 process i =1;
waiting form sem1                          increase i to 2;  
waiting form sem1                          release sem1; 
acquire sem1 but i ==2;                     condition check: i ==2; OK;    
process i =2;                              waiting form sem2    
increase i to 3;                           waiting form sem2
release sem2;                              you acquire sem2 but  i ==3; 
condition check: i ==3; OK;                 process i =3;
waiting form sem1                          increase i to 4;  
waiting form sem1                          release sem1; 
acquire sem1 but i==4!!!!!!
you call ->> orderList.get(i) -> exception thrown