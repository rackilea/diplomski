for (int x = 0; x < 10; ++x) {
  System.out.println("Enter number: " + (x + 1));
  int num = scan.nextInt(); // <-- get user input to
                            // test.
  // Test for negative first.
  if (num < 0) {
    negativeList[neg++] = num;
  } else {
    // It isn't negative.
    if (num % 2 == 0) {
      // It is even.
      evenList[even++] = num;
    } else {
      // It must be odd.
      oddList[odd++] = num;
    }
  }
}