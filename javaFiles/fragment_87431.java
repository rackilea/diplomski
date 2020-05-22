System.out.print(scanName + ", height (inches): ");
  boolean failed = false;
  try {
     scanHeight = scan.nextInt();
  }
  catch(InputMismatchException e)
  {
     failed = true;
  }
  if (failed || (scanHeight < 60) || (scanHeight > 84))
  {
     System.out.println("Invalid height - must be between 60 to 84 inches, inclusively");      // Error message it displays
     System.exit(0);
  }