int main() {
  std::minstd_rand0 eng;
  std::bernoulli_distribution dist(probability_sum_is_over_threshold);

  for (int i=0; i< 100000000; ++i) {
    if (dist(eng)) {
    } else {
    }
  }
}