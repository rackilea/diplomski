int currentNumber = 0;

// pre-increment (function receives 1)
doSomethingOnNumber(++currentNumber);

// vs
currentNumber = 0;

// post-increment (function receives 0)
doSomethingOnNumber(currentNumber++);