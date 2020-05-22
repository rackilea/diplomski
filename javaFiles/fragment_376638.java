StreamEx.
   of(1, 2, 3, 4, 5, 6).
   map(toNull).
   nonNull().
   map(item -> item != null ? toNonNull.apply(item) : null).
   count();