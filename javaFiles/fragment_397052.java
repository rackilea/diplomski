struct sum_trials {
  std::binomial_distribution<> dist;
  double A; double B; int trials;

  sum_trials(int t, double p, double a, double b) : dist{t, p}, A{a}, B{b}, trials{t} {}

  double operator() () {
    int successes = dist(eng);
    return successes * A + (trials - successes) * B;
  }
};

int main() {
  int threshold = 5;
  int composition[5] = { 10, 10, 10, 10, 10 };

  sum_trials carbon   = { composition[0], 107.0/10000.0, 13.003354378, 12.0};
  sum_trials hydrogen = { composition[1], 107.0/10000.0, 13.003354378, 12.0};
  sum_trials nitrogen = { composition[2], 107.0/10000.0, 13.003354378, 12.0};
  sum_trials oxygen   = { composition[3], 107.0/10000.0, 13.003354378, 12.0};
  sum_trials sulfur   = { composition[4], 107.0/10000.0, 13.003354378, 12.0};


  for (int i = 0; i < 100000000; i++) {
     double sum = 0;

     sum += carbon();
     sum += hydrogen();
     sum += nitrogen();
     sum += oxygen();
     sum += sulfur();

     if (sum > threshold) {
     } else {
     }
   }
}