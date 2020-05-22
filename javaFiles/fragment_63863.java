int [] inputTenThousand2 = new int[10000];     // 10000 sorted integers
for (int v = 0; v < 1000; v++) { // loop from 0 to 999
    for (int i = 0; i < 10; i++) { 
        inputTenThousand2[(10*v) + i] = v + 1; // Set ten elements per value of the outer loop
    }
}