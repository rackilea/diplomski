1st call: dectoBin(7) =>  return  7 % 2 + 10 * dectoBin(7/2); => 1 + 10 * dectoBin(3);

2nd call: dectoBin(3) =>  return  3 % 2 + 10 * dectoBin(3/2); => 1 + 10 * dectoBin(1);

3rd call: dectoBin(1) =>  return  1 % 2 + 10 * dectoBin(1/2); => 1 + 10 * dectoBin(0);

4th call: dectoBin(0) =>  return  0; // base case