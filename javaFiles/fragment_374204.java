SomeType s = null;     // the declaration sets aside space for one
                         // reference, and the initialization assigns
                         // `null` to it.

  s = new SomeType(...)  // the 'new' expression creates the object and 
                         // which allocates the space, etcetera
                         // the assignment merely assigns the reference
                         // for that object to 's'.