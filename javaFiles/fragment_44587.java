public int timeDecrementFromZeroInt(int reps) {
    int sum = rnd.nextInt();
    for (int i = 0; i < reps; i++) {
      for (int j = 0; j > Integer.MIN_VALUE; j--) sum += j;
    }
    return sum;
  }
  public long timeDecrementFromZero(int reps) {
    long sum = rnd.nextLong();
    for (long i = 0; i < reps; i++) {
      for (long j = 0; j > Integer.MIN_VALUE; j--) sum += j;
    }
    return sum;
  }
  public long timeIncrementFromZero(int reps) {
    long sum = rnd.nextLong();
    for (long i = 0; i < reps; i++) {
      for (long j = 0; j < Integer.MAX_VALUE; j++) sum += j;
    }
    return sum;
  }
  public long timeDecrementToZero(int reps) {
    long sum = rnd.nextLong();
    for (long i = 0; i < reps; i++) {
      for (long j = Integer.MAX_VALUE; j >= 0; j--) sum += j;
    }
    return sum;
  }
  public long timeIncrementToZero(int reps) {
    long sum = rnd.nextLong();
    for (long i = 0; i < reps; i++) {
      for (long j = Integer.MIN_VALUE; j < 0; j++) sum += j;
    }
    return sum;
  }