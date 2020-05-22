struct sum_trials2 {
  std::binomial_distribution<> d1;
  std::binomial_distribution<> d2;
  double A; double B; double C;
  int trials;
  double probabilty2;

  sum_trials2(int t, double p1, double p2, double a, double b, double c)
    : d1{t, p1}, A{a}, B{b}, C{c}, trials{t}, probability2{p2} {}

  double operator() () {
    int X = d1(eng);
    d2.param(std::binomial_distribution<>{trials-X, p2}.param());
    int Y = d2(eng);

    return X*A + Y*B + (trials-X-Y)*C;
  }
};

sum_trials2 oxygen{composition[3], 17.0/1000.0, (47.0-17.0)/(1000.0-17.0), 17.9999, 16.999, 15.999};