while (input != -99) { // Break BEFORE setting low to -99.
  if (input > high)
  {
    high = input;
  }
  if (input < low)
  {
    low = input;
  }

  System.out.println("Please Enter the AN INTEGER (Press -99 to Exit): \n");
  input = keyboard.nextInt();
}