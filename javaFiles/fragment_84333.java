Address[] addArr1 = new Address[2];
Address[] addArr2 = new Address[2];
addArr1[0] = new Address (...);
addArr2[0] = addArr1[0]; // the shared Address
addArr1[1] = new Address (...); // unique Address
addArr2[1] = new Address (...); // unique Address
Person p1 = new Person (addArr1);
Person p2 = new Person (addArr2);