A[] tab = new A[7];
tab[0] = new B(-10); // permitted since B derives from A
tab[1] = new A();
// ...
tab[2].analyser(tab[1]);
tab[5].analyser(tab[1]);