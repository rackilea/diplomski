int difference, z;
while (!firstNum.isEmpty ())
{
  x = firstNum.pop();
  y = 0;
  if (!secondNum.isEmpty ()) // account for the case when secondNum has less digits
    y = secondNum.pop();
  difference = x - y;
  if (difference < 0)
  {
    z = firstNum.pop();
    firstNum.push(z - 1);
    result.push(difference + 10); // fixed this line, since you want to push the
                                  // difference to the result
  }
  else
  {
    result.push(difference);
  }
}