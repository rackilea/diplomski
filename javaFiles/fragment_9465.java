(?<=               # open the lookbehind: preceded by...
    \[             # a literal [
    [^]]{1,1000}   # between one and 1000 characters that are not a ]
    ]              # literal ]
    \s{0,1000}     # between zero and 1000 white-spaces
)                  # close the lookbehind
\S+                # one or more characters that are not white-spaces