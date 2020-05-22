// Define your variables
int x = 130;
int y = 0;

    while(y < x) {
       // Check if y would be greater than x if you added 100 to it
       if (y + 100 > x)
          // If so, we won't add 100 to y. We'll just assign x to y.
          y = x;
       else
          // If not, we can safely add 100 to it.
          y += 100;
    }