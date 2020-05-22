NODE                     EXPLANATION
---------------------------------------------------------------------
  ^                        the beginning of the string
---------------------------------------------------------------------
  \p{Alpha}                any character of: letters
---------------------------------------------------------------------
  .*                       any character except \n (0 or more times
                           (matching the most amount possible))
---------------------------------------------------------------------
  $                        before an optional \n, and the end of the
                           string