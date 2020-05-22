T1             T2             T3
test.nr = 5;   
test.setA(a1);
               test.nr = 6;   
               test.setA(a2); 
                              test.nr = 7;
                              test.getA(); //gives a2
                              print(test.nr); //gives 5,6 or 7