for (long i = 1; i < (1L << NB); i = (i << 1) | 1) {
  long j = i;
  do {
    System.out.println(Long.toBinaryString(j));
    if(checkSolution(j)) {
        this.add(j); // add j to solutions
    }
    j = next_of_n(j);
  } while (j < (1L << NB));
}