try {
   // ...
 } catch (SQLException e) {
  if (e.getMessage().toLowerString().contains("duplicate table name")) {
   // handle duplicate table name problem
  } else if ( /* ... */ ) {
   // ...
  }
 }