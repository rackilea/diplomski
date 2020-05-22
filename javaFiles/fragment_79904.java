^                                 # Beginning of the string
[a-zA-Z0-9]                       # First character is not special
[a-zA-Z0-9+!#$%&*/=?`{|}~'_-]*    # 0 or more alphanumeric and special characters, except .
(?:                               # Group, repeated 0 or more times
  \.                              # A literal .
  [a-zA-Z0-9+!#$%&*/=?`{|}~'_-]+  # 1 or more alphanumeric and special characters, except .
)*