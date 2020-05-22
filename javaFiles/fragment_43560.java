Main m1 = new Main();     // create new Main object 'm1'
Main m2 = m1;             // assign 'm2' to reference 'm1' (no new object)
Main m3 = new Main();     // create new Main object 'm3'
m2.num = 60;              // assign a field in 'm2' (no new object)
gacemarks(m2);            // repeatedly increment the 'm2.num' field (no new object)
System.out.println(m2);   // print 'm2' (no new object)