______________________
si ------> |new SecondIteration();|   // You have 1 reference to this object
           ------------------------ 

r1 = si;  // Make Runnable reference `r1` point the same object that `si` refers

            ______________________
si ------> |new SecondIteration();|   // Now you have 2 reference to this object
           ------------------------
            ^
            |
r1 ----------