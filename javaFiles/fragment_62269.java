boolean swapped; // to notice swaps during a pass
    do {
        swapped = false;
        for (int i=1; i<a.length; i++)
            if (a[i-1] > a[i]) {
                // Swap!
                int swap = a[i];
                a[i] = a[i-1];
                a[i-1] = swap;
                swapped = true;
            }
      } while (swapped); // another pass if swaps happened