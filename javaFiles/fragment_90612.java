(?i)            # Case insensitive flag
[-a-z0-9+_]     # First character
[-a-z0-9+_.]*   # Zero or more characters
@               # Literal '@' character
[-a-z0-9]       # Match a single character
[-a-z0-9.]*     # Match zero or more characters
\.              # Literal '.' character
[a-z]{2,6}      # Match 2 through 6 alpha characters