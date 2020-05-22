public static void subtract ()
  {
    Stack<Integer> firstNum = new Stack<Integer>();
    Stack<Integer> secondNum = new Stack<Integer>();
    Stack<Integer> result = new Stack<Integer>();

    // firstNum == 3002
    firstNum.push (3);
    firstNum.push (0);
    firstNum.push (0);
    firstNum.push (2);

    // secondNum == 129
    secondNum.push (1);
    secondNum.push (2);
    secondNum.push (9);

    int difference, z;
    while (!firstNum.isEmpty ())
    {
      int x = firstNum.pop();
      int y = 0;
      if (!secondNum.isEmpty ())
        y = secondNum.pop();
      difference = x - y;
      if (difference < 0)
      {
        z = firstNum.pop();
        firstNum.push(z - 1);
        result.push(difference + 10);
      }
      else
      {
        result.push(difference);
      }
    }
    while (!result.isEmpty ())
      System.out.print (result.pop ());
    System.out.println ();
  }