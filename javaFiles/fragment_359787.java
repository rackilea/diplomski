// In cases where perm gen is collected, GC will want to mark
// oops referenced from nmethods active on thread stacks so as to
// prevent them from being collected. However, this visit should be
// restricted to certain phases of the collection only. The
// closure decides how it wants nmethods to be traced.
if (cf != NULL)
  cf->do_code_blob(_cb);