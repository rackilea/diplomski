void AdaptiveSizePolicy::check_gc_overhead_limit(
                                      size_t young_live,
                                      size_t eden_live,
                                      size_t max_old_gen_size,
                                      size_t max_eden_size,
                                      bool   is_full_gc,
                                      GCCause::Cause gc_cause,
                                      CollectorPolicy* collector_policy) {
  ...
  if (is_full_gc) {
    if (gc_cost() > gc_cost_limit &&
      free_in_old_gen < (size_t) mem_free_old_limit &&
      free_in_eden < (size_t) mem_free_eden_limit) {
      // Collections, on average, are taking too much time, and
      //      gc_cost() > gc_cost_limit
      // we have too little space available after a full gc.
      //      total_free_limit < mem_free_limit
      // where
      //   total_free_limit is the free space available in
      //     both generations
      //   total_mem is the total space available for allocation
      //     in both generations (survivor spaces are not included
      //     just as they are not included in eden_limit).
      //   mem_free_limit is a fraction of total_mem judged to be an
      //     acceptable amount that is still unused.
      // The heap can ask for the value of this variable when deciding
      // whether to thrown an OutOfMemory error.
      // Note that the gc time limit test only works for the collections
      // of the young gen + tenured gen and not for collections of the
      // permanent gen.  That is because the calculation of the space
      // freed by the collection is the free space in the young gen +
      // tenured gen.
      // At this point the GC overhead limit is being exceeded.
      inc_gc_overhead_limit_count();
      if (UseGCOverheadLimit) {
        if (gc_overhead_limit_count() >= AdaptiveSizePolicyGCTimeLimitThreshold){
          // All conditions have been met for throwing an out-of-memory
          set_gc_overhead_limit_exceeded(true);
          // Avoid consecutive OOM due to the gc time limit by resetting
          // the counter.
          reset_gc_overhead_limit_count();
      } else {
        ...
      }