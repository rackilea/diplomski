int max = customerName.length;
for (int i = 0; i < max; i++) {   // Traditional for loop
    if ("Meg".equals(customerName[i]) {    // Look for the name "Meg"
        // If found, shift the array elements down one.
        for (int j = i; j < (max - 1); j++) {
            customerName[j] = customerName[j+1];
        }
        i--;  // Check the i'th element again in case we just move "Meg" there.
        max--; // Reduce the size of our search of the array.
    }
}