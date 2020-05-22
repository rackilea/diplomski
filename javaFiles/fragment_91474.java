Op op;
BasicPattern pat = new BasicPattern();                 // Make a pattern
pat.add(pattern);                                      // Add our pattern match
op = new OpBGP(pat);                                   // Make a BGP from this pattern
op = OpFilter.filter(e, op);                           // Filter that pattern with our expression
op = new OpProject(op, Arrays.asList(Var.alloc("s"))); // Reduce to just ?s
Query q = OpAsQuery.asQuery(op);                       // Convert to a query
q.setQuerySelectType();                                // Make is a select query