// Don't unroll if the next round of unrolling would push us
  // over the expected trip count of the loop.  One is subtracted
  // from the expected trip count because the pre-loop normally
  // executes 1 iteration.
  if (UnrollLimitForProfileCheck > 0 &&
      cl->profile_trip_cnt() != COUNT_UNKNOWN &&
      future_unroll_ct        > UnrollLimitForProfileCheck &&
      (float)future_unroll_ct > cl->profile_trip_cnt() - 1.0) {
    return false;
  }