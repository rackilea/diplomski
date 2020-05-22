175   if (_gc_count_before == gch->total_collections()) {
  176     // The "full" of do_full_collection call below "forces"
  177     // a collection; the second arg, 0, below ensures that
  178     // only the young gen is collected. XXX In the future,
  179     // we'll probably need to have something in this interface
  180     // to say do this only if we are sure we will not bail
  181     // out to a full collection in this attempt, but that's
  182     // for the future.