public double eval(int n, double[] X, double[] Y) {
  switch (n) {
    case 0: return eval0(X, Y);
    case 1: return eval1(X, Y);
    case 2: return eval2(X, Y);
    case 3: return eval3(X, Y);
    case 4: return eval4(X, Y);
    case 5: return eval5(X, Y);
    case 8: return eval8(X, Y);
    case 11: return eval11(X, Y);
    case 15: return eval15(X, Y);
    case 21: return eval21(X, Y);
    case 29: return eval29(X, Y);
    case 40: return eval40(X, Y);
    case 57: return eval57(X, Y);
    case 79: return eval79(X, Y);
    case 111: return eval111(X, Y);
    case 156: return eval156(X, Y);
    case 218: return eval218(X, Y);
    case 305: return eval305(X, Y);
  }
  assert(false);
  return -1;
}